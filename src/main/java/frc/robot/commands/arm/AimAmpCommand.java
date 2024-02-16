package frc.robot.commands.arm;

import frc.robot.subsystems.ArmSubsystem;

// Move arm to amp shoot pose
// Set shooter speed
public class AimAmpCommand extends ArmBaseCommand {

    private double aimSpeed;
    private double armSpeed;
    private double aimSpeedEncoder;
    private double aimAngleEncoder;
    private double armAngleEncoder;
    private double armSpeedEncoder;


    public AimAmpCommand(ArmSubsystem armSubsystem) {

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

