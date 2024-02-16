package frc.robot.commands.arm;

import frc.robot.subsystems.ArmSubsystem;

// Move arm to speaker shoot pose
// Set shooter speed (distance based)
public class CompactPoseCommand extends ArmBaseCommand {

    private double aimSpeed;
    private double armSpeed;
    private double aimSpeedEncoder;
    private double aimAngleEncoder;
    private double armAngleEncoder;
    private double armSpeedEncoder;

    public void CompactPoseCommand(ArmSubsystem armSubsystem) {

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // (do math based on distance here?) adjust aim to speaker
        // (do math based on distance here?) set motor speed
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}