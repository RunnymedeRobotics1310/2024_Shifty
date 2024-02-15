package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

// Start Intake
// Align with Note
public class StartIntakeCommand extends Command {

    private double aimSpeed;
    private double encoderAimSpeed;
    private double encoderAimAngle;


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

    }
}