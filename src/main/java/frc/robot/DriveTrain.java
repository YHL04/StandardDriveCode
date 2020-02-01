package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveTrain {

    Joystick joy;
    TalonSRX motor1, motor2;
    VictorSPX motor3, motor4;

    double leftTrigger, rightTrigger;
    double leftSpeed, rightSpeed, straightSpeed;
    double speed;

    DriveTrain(){
        joy = new Joystick(1);
        motor1 = new TalonSRX(1);
        motor2 = new TalonSRX(2);
        motor3 = new VictorSPX(3);
        motor4 = new VictorSPX(4);
    }

    public void run() {
        straightSpeed = joy.getRawAxis(1) / 2;
        straightSpeed = Math.abs(straightSpeed) < 0.05 ? 0 : straightSpeed;
        
        leftTrigger = (joy.getRawAxis(3) + 1) / 4;
        leftTrigger = leftTrigger < 0.05 ? 0 : leftTrigger;
        rightTrigger = (joy.getRawAxis(4) + 1)/ 4;
        rightTrigger = rightTrigger < 0.05 ? 0 : rightTrigger;

        leftSpeed = straightSpeed + leftTrigger - rightTrigger;
        rightSpeed = straightSpeed - leftTrigger + rightTrigger;



        

        
        
        

        

        // 1 2
        // 3 4

        motor1.set(ControlMode.PercentOutput, rightSpeed);
        motor2.set(ControlMode.PercentOutput, leftSpeed);
        motor3.set(ControlMode.PercentOutput, rightSpeed);
        motor4.set(ControlMode.PercentOutput, leftSpeed);
    }
}