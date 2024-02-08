// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootOnHeadingCommand extends Command {

    private final ShooterSubsystem shooterSubsystem;
    private final IntakeSubsystem  intakeSubsystem;
    private final DriveSubsystem   driveSubsystem;
    private final double           heading;
    private double                 headingError;


    private long                   startTimeMs = 0;

    /**
     * ShootOnHeading command turns to the specified heading then shoots
     *
     * @param driveSubsystem
     * @param heading
     */

    public ShootOnHeadingCommand(double heading, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem,
        DriveSubsystem driveSubsystem) {

        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem  = intakeSubsystem;
        this.driveSubsystem   = driveSubsystem;
        this.heading          = heading;


        // Add required subsystems
        addRequirements(shooterSubsystem);
        addRequirements(intakeSubsystem);
        addRequirements(driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTimeMs = System.currentTimeMillis();
        shooterSubsystem.setShooterSpeed(.2);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        headingError = driveSubsystem.getHeadingError(heading, driveSubsystem.getHeading());
        double errorF = headingError * 0.02;
        SmartDashboard.putNumber("errorF", errorF);
        driveSubsystem.setMotorSpeeds(+errorF, -errorF);

        if ((System.currentTimeMillis() - startTimeMs) > 3000) {
            intakeSubsystem.setIntakeSpeed(.1);
        }


        // Nothing to do here except wait for the end
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
        intakeSubsystem.stop();
        // When the command finishes, do nothing
        // NOTE: control will return to the driver
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (headingError < 0.5) {
            if (System.currentTimeMillis() - startTimeMs >= 4500) {
                System.out.println("Command finished");
                return true;
            }
        }
        return false;
    }
}
