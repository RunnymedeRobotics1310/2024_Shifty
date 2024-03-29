package frc.robot.commands.arm;

import frc.robot.subsystems.ArmSubsystem;

// start feeder motor
// wait
//then stop feeder motor
public class ShootCommand extends ArmBaseCommand {

    private double aimSpeed;
    private double armSpeed;
    private double aimSpeedEncoder;
    private double aimAngleEncoder;
    private double armAngleEncoder;
    private double armSpeedEncoder;


    public ShootCommand(ArmSubsystem armSubsystem) {

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // set motor speed
        // wait...
        // stop motor
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
