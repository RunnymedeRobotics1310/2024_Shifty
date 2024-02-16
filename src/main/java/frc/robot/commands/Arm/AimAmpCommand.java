package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

// Move arm to amp shoot pose
// Set shooter speed
public class AimAmpCommand extends Command {

    private double aimSpeed;
    private double armSpeed;
    private double encoderAimSpeed;
    private double encoderAimAngle;
    private double encoderArmAngle;
    private double encoderArmSpeed;


    public void AimAmpCommand(ArmSubsystem armSubsystem) {

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // adjust arm
        // Set shooter speed
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

}

