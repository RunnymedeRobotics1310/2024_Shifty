package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

// Start Intake
// Align with Note
public class StartIntakeCommand extends Command {

    private double aimSpeed;
    private double armSpeed;
    private double aimSpeedEncoder;
    private double aimAngleEncoder;
    private double armAngleEncoder;
    private double armSpeedEncoder;


    public void StartIntakeCommand(ArmSubsystem armSubsystem) {

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Set intake speed
        // line up with note
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}