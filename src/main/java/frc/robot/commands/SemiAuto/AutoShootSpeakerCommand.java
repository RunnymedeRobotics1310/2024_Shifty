package frc.robot.commands.SemiAuto;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class AutoShootSpeakerCommand extends Command {

    private double aimSpeed;
    private double armSpeed;
    private double encoderAimSpeed;
    private double encoderAimAngle;
    private double encoderArmAngle;
    private double encoderArmSpeed;


    public void AutoShootSpeakerCommand(ArmSubsystem armSubsystem) {
        // Steps:
        // Start Shooter
        // Align with Speaker
        // Aim
        // Shoot
        // Close arm

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}