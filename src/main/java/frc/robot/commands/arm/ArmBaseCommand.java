package frc.robot.commands.arm;

import frc.robot.Constants.ArmPosition;
import frc.robot.commands.LoggingCommand;

public abstract class ArmBaseCommand extends LoggingCommand {

    ArmPosition targetArmPosition;

    public void setArmTarget(ArmPosition armPosition) {
        targetArmPosition = armPosition;
    }


}
