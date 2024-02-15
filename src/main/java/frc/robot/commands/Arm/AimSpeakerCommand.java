package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

// Move arm to speaker shoot pose
// Set shooter speed (distance based)
public class AimSpeakerCommand extends Command {

    private double aimSpeed;
    private double shooterSpeed;
    private double encoderAimSpeed;
    private double encoderAimAngle;
    private double encoderShooterSpeed;


    public void AimSpeakerCommand(ArmSubsystem armSubsystem) {

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // adjust aim to speaker(use distance from vision and adjust angle accordingly)
        // set motor speed
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {

    }
}
