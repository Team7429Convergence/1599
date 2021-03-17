package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain {
    CANSparkMax leftSlave = new CANSparkMax(RobotMap.DriveTrain_leftSlave, MotorType.kBrushless);
    CANSparkMax leftMaster = new CANSparkMax(RobotMap.DriveTrain_leftMaster, MotorType.kBrushless);
    CANSparkMax rightSlave = new CANSparkMax(RobotMap.DriveTrain_rightSlave, MotorType.kBrushless);
    CANSparkMax rightMaster = new CANSparkMax(RobotMap.DriveTrain_rightMaster, MotorType.kBrushless);

    CANPIDController leftMasterPID = leftSlave.getPIDController();

    CANEncoder leftMasterEncoder = leftMaster.getEncoder();

    public void RobotInit() {
        leftSlave.restoreFactoryDefaults();
        leftMaster.restoreFactoryDefaults();
        rightSlave.restoreFactoryDefaults();
        rightMaster.restoreFactoryDefaults();

        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
        rightMaster.follow(leftMaster, true);

        leftMasterEncoder.setPosition(0);

        leftMasterPID.setP(RobotMap.kP);
        leftMasterPID.setI(RobotMap.kI);
        leftMasterPID.setD(RobotMap.kD);
        leftMasterPID.setIZone(RobotMap.kIz);
        leftMasterPID.setFF(RobotMap.kFF);
        leftMasterPID.setOutputRange(RobotMap.kMinOutput, RobotMap.kMaxOutput);
    }

    public boolean DriveByInches(double position) {
        leftMasterEncoder.setPosition(0);
        double[] data = new double[4];
        data[0] = position;
        data[1] = RobotMap.DriveTrain_wheelSize;
        data[2] = RobotMap.DriveTrain_encodersPerRev;
        data[3] = RobotMap.DriveTrain_gearRatio;
        int encoders = Conversions.inchesToEncoders(data);
        while((leftMasterEncoder.getPosition() < (encoders * .97)) || (leftMasterEncoder.getPosition() > (encoders * 1.03))){
          leftMasterPID.setReference(encoders, ControlType.kPosition);
        }
        return true;
      }
}
