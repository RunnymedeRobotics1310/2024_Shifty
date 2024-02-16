package frc.robot.commands.arm;

import frc.robot.subsystems.ArmSubsystem;

// Move arm to speaker shoot pose
// Set shooter speed (distance based)
public class AimSpeakerCommand extends ArmBaseCommand {

    private double aimSpeed;
    private double armSpeed;
    private double aimSpeedEncoder;
    private double aimAngleEncoder;
    private double armAngleEncoder;
    private double armSpeedEncoder;


    public AimSpeakerCommand(ArmSubsystem armSubsystem) {

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
        return true;
    }
}
