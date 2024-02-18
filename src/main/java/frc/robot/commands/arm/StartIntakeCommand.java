package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ArmPosition;
import frc.robot.subsystems.ArmSubsystem;

// Start Intake
// Move Aim/Arm
public class StartIntakeCommand extends ArmBaseCommand {

    private enum State {
        MOVE_AIM_ABOVE_90, MOVE_TO_TARGET
    };

    private State              state             = State.MOVE_AIM_ABOVE_90;
    private ArmPosition        targetArmPosition = ArmConstants.INTAKE_ARM_POSITION;

    private final ArmSubsystem armSubsystem;

    public StartIntakeCommand(ArmSubsystem armSubsystem) {

        this.armSubsystem = armSubsystem;

        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {

        // If there is a note inside the robot, then do not start this command
        if (armSubsystem.isNoteDetected()) {
            System.out.println("Note detected in robot.  StartIntakeCommand cancelled");
            return;
        }

        logCommandStart();

        if (armSubsystem.getAimAngle() < 90) {
            state = State.MOVE_AIM_ABOVE_90;
        }
        else {
            state = State.MOVE_TO_TARGET;
        }

        // Start the intake wheels
        armSubsystem.setIntakeSpeed(ArmConstants.INTAKE_SPEED);
    }

    @Override
    public void execute() {

        // If there is a note detected, then there is nothing to do
        if (armSubsystem.isNoteDetected()) {
            return;
        }

        switch (state) {

        case MOVE_AIM_ABOVE_90:

            armSubsystem.setAimSpeed(ArmConstants.FAST_AIM_SPEED);
            armSubsystem.setArmSpeed(0);

            if (armSubsystem.getAimAngle() > 90) {
                state = State.MOVE_TO_TARGET;
            }

            break;

        case MOVE_TO_TARGET:

            // TODO: total arm + aim angle should not be greater than
            // NOTE: The arm and aim are geared the same so they move at the
            // same rate.

            double aimSpeed = ArmConstants.FAST_AIM_SPEED;


            if (Math.abs(targetArmPosition.aimAngle - armSubsystem.getAimAngle()) < ArmConstants.SLOW_ARM_ZONE_DEG) {
                aimSpeed = ArmConstants.SLOW_AIM_SPEED;
            }

            if (Math.abs(targetArmPosition.aimAngle - armSubsystem.getAimAngle()) < ArmConstants.AT_TARGET_DEG) {
                aimSpeed = 0;
            }

            if (armSubsystem.getAimAngle() > targetArmPosition.aimAngle) {
                aimSpeed *= -1.0;
            }

            armSubsystem.setAimSpeed(aimSpeed);

            /*
             * Set Aim
             */
            double armSpeed = ArmConstants.FAST_ARM_SPEED;


            if (Math.abs(targetArmPosition.armAngle - armSubsystem.getArmAngle()) < ArmConstants.SLOW_ARM_ZONE_DEG) {
                armSpeed = ArmConstants.SLOW_ARM_SPEED;
            }

            if (Math.abs(targetArmPosition.armAngle - armSubsystem.getArmAngle()) < ArmConstants.AT_TARGET_DEG) {
                armSpeed = 0;
            }

            if (armSubsystem.getArmAngle() > targetArmPosition.armAngle) {
                armSpeed *= -1.0;
            }

            armSubsystem.setArmSpeed(armSpeed);

            break;
        }
    }

    @Override
    public boolean isFinished() {

        // If there is a note detected, then this command ends
        if (armSubsystem.isNoteDetected()) {
            setFinishReason("Note detected");
            return true;
        }

        return false;
    }

    @Override
    public void end(boolean interrupted) {

        armSubsystem.stop();

        logCommandEnd(interrupted);

        CommandScheduler.getInstance().schedule(new CompactPoseCommand(armSubsystem));
    }

}