/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/*
* the group classes this class resides in, as seen in the folder on the left
* affects class acesss modifiers
* helps with naming conflicts
* built in packages to java like java.util exist and are used for imports
*  */
package org.firstinspires.ftc.teamcode;

/* these imports let this class use other FTC classes' code without having to reference their package and name location every time
* whole packages, iterfaces, and classes can be imported, from our project or Java's standard built-in ones
*/
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


//this some bullshit
//skip over
/*
 * This file contains an example of a Linear "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode is executed.
 *
 * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
 * This code will work with either a Mecanum-Drive or an X-Drive train.
 * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
 * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
 *
 * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
 *
 * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
 * Each motion axis is controlled by one Joystick axis.
 *
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 *
 * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
 * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
 * the direction of all 4 motors (see code below).
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */





// determines how this program shows up on our robot controller. detected by the FTC android SDK
@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")
//declares this program as a public class named BasiciOpMode_Linear of type LinearOpMode, inheriting methods from the LinearOpMode class
public class BasiciOpMode_Linear extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors
    //declared as null as they will be defined later but they should default to null
    // .
    //more variables can be put here

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    private CRServo wheel;
    private Servo schlonk;

    //Overrides the runOpMode method that is inherited from LinearOpMode to run this code instead
    @Override
    public void runOpMode() {
        /*
        * this code triggers when the initialize button is pressed
        * runs through sequentially once then waits
        * variables can be declared here as well
        * */

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");
        schlonk = hardwareMap.get(Servo.class, "schlonk");
        wheel = hardwareMap.get(CRServo.class, "wheel");

        //not important drive information you dont need to read this
        // ########################################################################################
        // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
        // ########################################################################################
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.

        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        /* begins once the run button is pressed and driver control starts
        *  loops through the code sequentially, from top to bottom line by line, until the stop button is pressed and the while loop condition becomes false
        * */
        while (opModeIsActive()) {

            /*START*/

            //Motor Control

                //setPower()
                motor.setPower(double);
                //example usages
                leftFrontDrive.setPower(0);
                rightBackDrive.setPower(gamepad1.left_stick_y * -0.5);

                //setDirection()
                //only really should be used once at the begining of your code to correct for differing motor directions on the robot
                leftFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);
                leftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);

                //getters
                leftFrontDrive.getPower();
                leftFrontDrive.getCurrentPosition();
                leftFrontDrive.getDirection();

            //Positional Servo Ccontrol
            //Remember Servo modes must be changed with the servo controller manually
            //positional servo start and endpoints cannot be changed, alterations must be made manually, with a screwdriver

                //setPosition()
                servo.setPosition(double);
                schlonk.setPosition(1);

                //getters
                schlonk.getPosition();//this one more important
                schlonk.getDirection();

            //Continuous Servo Control(mostly treated as a motor)

                //setters
                wheel.setPower(1);
                wheel.setDirection(DcMotorSimple.Direction.REVERSE);

                //getters
                wheel.getPower();
                wheel.getDirection();

            //GAMEPAD
                //always references gamepad1 or gamepad2

                //floats(decimal variable, stores les than double)
                gamepad1.left_stick_y;
                gamepad1.left_stick_x;
                gamepad2.right_stick_y;
                gamepad2.right_stick_x;

                gamepad1.right_trigger;
                gamepad1.left_trigger;

                //booleans
                gamepad1.right_bumper;
                gamepad1.left_bumper;

                gamepad1.dpad_right;
                gamepad1.dpad_left;
                gamepad1.dpad_up;
                gamepad1.dpad_down;

                gamepad1.a;
                gamepad1.b;
                gamepad1.x;
                gamepad1.y;

                gamepad1.left_stick_button;
                gamepad1.right_stick_button;

            //Conditional Statements
            /*
            * all this stuff is easy to google or ask AI about
            * remember everything gets looped through one by one
            * use your logic or use ChatGPT
            * you can look at our old driver control programs
            * */

            // and &&
            // or ||
            // not prefix !

            //equals(condition not declaration) ==
            //not equals !=
            //comparisons  < > <= >=

            //remember math
            //google stuff or ask chatGPT about the math code if you dont remember maths


            if(conditions){
                do all this
            }else if(conditions){
                do all this instead
            }else{
                default to this
            }

            //LOOPS

                /*DO NOT USE MORE LOOPS INSIDE THIS LOOP
                * unless you have a plan
                * do not use any "while" or "for" loops here
                * remember everything is already getting looped through inside this loop*/


            /*END*/


            // Shows the elapsed game time and wheel power.
            //writing, variables, time, statuses can all be displayed
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            //flushes the data so it appears on the screen
            telemetry.update();
        }
    }}
