package frc.robot.operator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.CancelCommand;
import frc.robot.commands.SystemTestCommand;
import frc.robot.commands.arm.ShootCommand;
import frc.robot.commands.arm.StartIntakeCommand;
import frc.robot.commands.drive.DriveToTargetCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.JackmanVisionSubsystem;

/**
 * The Operator input class is used to map buttons to functions and functions to commands
 * <p>
 * This class extends SubsystemBase so that the periodic() routine is called each loop. The periodic
 * routine can be used to send debug information to the dashboard
 */
public class OperatorInput extends SubsystemBase {

    public final GameController driverController = new GameController(
        OperatorConstants.DRIVER_CONTROLLER_PORT,
        OperatorConstants.GAME_CONTROLLER_STICK_DEADBAND);


    // Allow the system test command to access the controller directly
    public GameController getDriverController() {
        return driverController;
    }

    /*
     * Map all functions to buttons.
     *
     * A function should be a description of the robot behavior it is triggering.
     *
     * This separation of concerns allows for remapping of the robot functions to different
     * controller buttons without the need to change the command or the trigger. The mapping
     * from controller button to function is done in the following methods.
     */

    // Cancel all commands when the driver presses the XBox controller three lines (aka. start)
    // button
    public boolean isCancelPressed() {
        return driverController.getStartButton();
    }

    public boolean isShoot() {
        return driverController.getYButton();
    }

    public boolean isStartIntakePressed() {
        return driverController.getAButton();
    }

    public boolean isCompactPressed() {
        return driverController.getXButton();
    }

    public boolean isSystemTestPressed() {
        return driverController.getStartButton() && driverController.getBackButton();
    }



    /**
     * Use this method to define your robotFunction -> command mappings.
     *
     * NOTE: all subsystems should be passed into this method.
     */
    public void configureButtonBindings(DriveSubsystem driveSubsystem, ArmSubsystem armSubsystem,
        JackmanVisionSubsystem visionSubsystem) {

        new Trigger(() -> isCancelPressed())
            .onTrue(new CancelCommand(this, driveSubsystem));

        new Trigger(() -> isSystemTestPressed() && !DriverStation.isFMSAttached())
            .onTrue(new SystemTestCommand(this, armSubsystem));

        new Trigger(() -> isShoot())
            .onTrue(new ShootCommand(armSubsystem));

        new Trigger(() -> isStartIntakePressed())
            .onTrue(new StartIntakeCommand(armSubsystem));

        new Trigger(() -> isCompactPressed())
            .onTrue(new DriveToTargetCommand(1, 0.2, driveSubsystem, visionSubsystem));
    }

    @Override
    public void periodic() {

        // Display any operator input values on the smart dashboard.

        SmartDashboard.putString("Driver Controller", driverController.toString());
    }

}
