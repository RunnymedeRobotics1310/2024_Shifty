// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeCommand extends Command {

    private final IntakeSubsystem intakeSubsystem;

    private long                  startTimeMs = 0;

    /**
     * DriveForTime command drives at the specified heading at the specified speed for the specified
     * time.
     *
     * @param timeoutSeconds to run the command
     * @param speed in the range -1.0 to
     */
    public IntakeCommand(IntakeSubsystem intakeSubsystem) {

        this.intakeSubsystem = intakeSubsystem;


        // Add required subsystems
        addRequirements(intakeSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTimeMs = System.currentTimeMillis();
        intakeSubsystem.setIntakeSpeed(.2);

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // Nothing to do here except wait for the end
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
        // When the command finishes, do nothing
        // NOTE: control will return to the driver
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {

        if (intakeSubsystem.isGamepieceDetected()) {
            System.out.println("Command finished");
            return true;
        }

        return false;
    }
}
