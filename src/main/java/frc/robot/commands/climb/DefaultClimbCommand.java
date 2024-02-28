package frc.robot.commands.climb;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ClimbConstants;
import frc.robot.commands.LoggingCommand;
import frc.robot.operator.GameController;
import frc.robot.subsystems.ClimbSubsystem;

public class DefaultClimbCommand extends LoggingCommand {

    private final ClimbSubsystem climbSubsystem;
    private final XboxController driverController;

    /**
     * Creates a new ExampleCommand.
     *
     * @param climbSubsystem The subsystem used by this command.
     */
    public DefaultClimbCommand(GameController driverController, ClimbSubsystem climbSubsystem) {

        this.driverController = driverController;
        this.climbSubsystem   = climbSubsystem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(climbSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        logCommandStart();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        boolean leftUp    = driverController.getLeftBumper();
        boolean leftDown  = (driverController.getLeftTriggerAxis() == 1);

        boolean rightUp   = driverController.getRightBumper();
        boolean rightDown = (driverController.getRightTriggerAxis() == 1);

        if (leftUp) {
            setLeftClimbSpeed(ClimbConstants.SLOW_CLIMB_SPEED);
        }
        else if (leftDown) {
            setLeftClimbSpeed(ClimbConstants.SLOW_CLIMB_SPEED * -1);
        }

        if (rightUp) {
            setRightClimbSpeed(ClimbConstants.SLOW_CLIMB_SPEED);
        }
        else if (rightDown) {
            setRightClimbSpeed(ClimbConstants.SLOW_CLIMB_SPEED * -1);
        }


    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // The default drive command never ends, but can be interrupted by other commands.
        return false;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        logCommandEnd(interrupted);
    }

    private void setLeftClimbSpeed(double speed) {

        climbSubsystem.setLeftClimbSpeed(speed);
    }

    private void setRightClimbSpeed(double speed) {

        climbSubsystem.setRightClimbSpeed(speed);
    }

}