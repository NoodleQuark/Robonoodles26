package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Kronk25", group = "a")
public class Kronk25 extends LinearOpMode {




    private DcMotor frontright;
    private DcMotor backright;
    private DcMotor backleft;
    private DcMotor frontleft;
    private  CRServo wheel;
    private Servo basket;
    private Servo schlonk;
    //private Servo hook;
    private  DcMotor vertSlide;
    private DcMotor horizSlide;
    private DcMotor climb;
    private DcMotor wrist;
    private RevBlinkinLedDriver LED;



    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() throws InterruptedException {
        double magnitudeR;
        double Powervary;
        int Linear_Actuator__22Mode_22;
        double magnitudeL;
        long LEDstartTime = System.currentTimeMillis();
        long LEDwaitTime = 250;
        long LTime = System.currentTimeMillis();
        int ledMode = 0;
        boolean ENDGAME = false;
        long FWwaitTime = 0;
        long FWstartTime= System.currentTimeMillis();
        long BWstartTime = System.currentTimeMillis();
        long BWwaitTime = 0;
        boolean forwardWheel = true;
        boolean backWheel = true;
        boolean outtakeMode = false;
        boolean intakeMode = false;
        boolean outtakeMode2 = false;
        boolean vertSlideMode = false;
        boolean horizSlideMode = false;
        boolean wristMode = false;
        boolean wheelMode = false;
        boolean basketMode = false;
        boolean vertSlideOut = false;
        boolean horizSlideOut = false;
        boolean wristOut = false;
        boolean wheelOut = false;
        boolean basketOut = false;
        boolean vertSlideIn = false;
        boolean horizSlideIn = false;
        boolean wristIn = false;
        boolean wheelIn = false;
        boolean basketIn = false;
        boolean gp2A = true ;
        boolean gp2B = true;
        boolean gp2Y = true;
        double schlonkForward;
        double schlonkBackward;





        backleft = hardwareMap.get(DcMotor.class, "backleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        frontright = hardwareMap.get(DcMotor.class, "frontright");
        vertSlide = hardwareMap.get(DcMotor.class, "vertSlide");
        horizSlide = hardwareMap.get(DcMotor.class, "horizSlide");
        climb = hardwareMap.get(DcMotor.class, "climb");
        wrist = hardwareMap.get(DcMotor.class, "wrist");
        wheel = hardwareMap.get(CRServo.class, "wheel");
        basket = hardwareMap.get(Servo.class, "basket");
        schlonk = hardwareMap.get(Servo.class, "schlonk");
        //hook = hardwareMap.get(Servo.class, "hook");



        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            Linear_Actuator__22Mode_22 = 1;
            Powervary = 1;
            schlonk.setPosition(0.9625);
            //hook.setPosition(1);
            while (opModeIsActive()) {
                magnitudeR = Math.sqrt(Math.pow(gamepad1.right_stick_x, 2) + Math.pow(gamepad1.right_stick_y, 2));
                if (magnitudeR > 1) {
                    magnitudeR = 1;
                }
                magnitudeL = Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2));
                if (magnitudeL > 1) {
                    magnitudeL = 1;
                }
                if (gamepad1.right_stick_x <= 1 && gamepad1.right_stick_x >= 0 && gamepad1.right_stick_y <= 0) {
                    frontright.setPower(Powervary * 1 * magnitudeR * (1 - 2 * gamepad1.right_stick_x));
                    backright.setPower(Powervary * 1 * magnitudeR);
                }
                if (gamepad1.right_stick_x >= -1 && gamepad1.right_stick_x <= 0 && gamepad1.right_stick_y >= 0) {
                    frontright.setPower(Powervary * -1 * magnitudeR * (1 + 2 * gamepad1.right_stick_x));
                    backright.setPower(Powervary * -1 * magnitudeR);
                }
                if (gamepad1.right_stick_x <= 1 && gamepad1.right_stick_x >= 0 && gamepad1.right_stick_y >= 0) {
                    frontright.setPower(Powervary * -1 * magnitudeR);
                    backright.setPower(Powervary * -1 * magnitudeR * (1 - 2 * gamepad1.right_stick_x));
                }
                if (gamepad1.right_stick_x >= -1 && gamepad1.right_stick_x <= 0 && gamepad1.right_stick_y <= 0) {
                    frontright.setPower(Powervary * 1 * magnitudeR);
                    backright.setPower(Powervary * 1 * magnitudeR * (1 + 2 * gamepad1.right_stick_x));
                }
                if (gamepad1.left_stick_x <= 1 && gamepad1.left_stick_x >= 0 && gamepad1.left_stick_y >= 0) {
                    frontleft.setPower(Powervary * 1 * magnitudeL * (1 - 2 * gamepad1.left_stick_x));
                    backleft.setPower(Powervary * 1 * magnitudeL);
                }
                if (gamepad1.left_stick_x >= -1 && gamepad1.left_stick_x <= 0 && gamepad1.left_stick_y <= 0) {
                    frontleft.setPower(Powervary * -1 * magnitudeL * (1 + 2 * gamepad1.left_stick_x));
                    backleft.setPower(Powervary * -1 * magnitudeL);
                }
                if (gamepad1.left_stick_x <= 1 && gamepad1.left_stick_x >= 0 && gamepad1.left_stick_y <= 0) {
                    frontleft.setPower(Powervary * -1 * magnitudeL);
                    backleft.setPower(Powervary * -1 * magnitudeL * (1 - 2 * gamepad1.left_stick_x));
                }
                if (gamepad1.left_stick_x >= -1 && gamepad1.left_stick_x <= 0 && gamepad1.left_stick_y >= 0) {
                    frontleft.setPower(Powervary * 1 * magnitudeL);
                    backleft.setPower(Powervary * 1 * magnitudeL * (1 + 2 * gamepad1.left_stick_x));
                }
                if (gamepad1.a) {
                    Powervary = 0.5;
                }
                if (gamepad1.b) {
                    Powervary = 0.75;
                }
                if (gamepad1.x) {
                    Powervary = 1;
                }
                if (gamepad1.y) {
                    Powervary = 1;
                }

                //climb code

                if(gamepad1.left_trigger != 0){
                    climb.setPower(-gamepad1.left_trigger);
                }else if(gamepad1.right_trigger != 0){
                    climb.setPower(gamepad1.right_trigger);
                } else{
                    climb.setPower(0);
                }

                //Intake Code
                if (gamepad2.left_stick_y != 0) {
                    wristMode = false;
                    wrist.setPower(gamepad2.left_stick_y);
                } else if(!wristMode && wrist.getCurrentPosition() <= -775){
                    wrist.setPower(0.035);
                } else if (!wristMode) {
                    wrist.setPower(0);
                }
                if (gamepad2.right_stick_y != 0) {
                    horizSlideMode = false;
                    horizSlide.setPower(-gamepad2.right_stick_y);
                } else if(!horizSlideMode){
                    horizSlide.setPower(0);
                }
                //Outake Code
                if (gamepad2.left_trigger == 0 && gamepad2.right_trigger > 0) {
                    vertSlideMode = false;
                    vertSlide.setPower(-1 * gamepad2.right_trigger);
                } else if (gamepad2.left_trigger > 0 && gamepad2.right_trigger == 0) {
                    vertSlideMode = false;
                    vertSlide.setPower(gamepad2.left_trigger);
                } else if(!vertSlideMode){
                    vertSlide.setPower(-0.1);
                }
                //Basket Code
                if(gamepad2.right_bumper){
                    basketMode = false;
                    basket.setPosition(0.125);
                } else if (gamepad2.left_bumper) {
                    basketMode = false;
                    basket.setPosition(0.45);
                }else if(gamepad2.dpad_right || gamepad2.dpad_left){
                    basketMode = false;
                    basket.setPosition(0.3);
                }
                schlonkForward = schlonk.getPosition()  -0.0375;
                schlonkBackward = schlonk.getPosition() +0.0375;
                //schlonk code
                if((gamepad2.x || gamepad1.dpad_up || gamepad1.right_bumper) && schlonk.getPosition() >= 0.39){
                    //schlonk.setPosition(0.6);
                    schlonk.setPosition(schlonkForward);
                }else if ((gamepad2.a || gamepad1.dpad_down || gamepad1.left_bumper) && schlonk.getPosition() <= 0.9625){
                    //schlonk.setPosition(1);
                    schlonk.setPosition(schlonkBackward);
                }else if (schlonk.getPosition()>= 0.9625){
                    schlonk.setPosition(0.9625);
                }
                telemetry.addData("schlonk pos:", schlonk.getPosition());
                //Wheel Code
                if (gamepad2.dpad_up&& !(System.currentTimeMillis() - FWstartTime < FWwaitTime)) {
                    wheelMode = false;
                    if (forwardWheel) {
                        wheel.setPower(1);
                        FWstartTime = System.currentTimeMillis();
                        FWwaitTime = 200;
                    } else {
                        wheel.setPower(0);
                        FWstartTime = System.currentTimeMillis();
                        FWwaitTime = 200;
                    }
                    forwardWheel = !forwardWheel;

                }
                if (gamepad2.dpad_down&& !(System.currentTimeMillis() - BWstartTime < BWwaitTime)) {
                    wheelMode = false;
                    if (backWheel) {
                        wheel.setPower(-1);
                        BWstartTime = System.currentTimeMillis();
                        BWwaitTime = 400;
                    } else {
                        wheel.setPower(0);
                        BWstartTime = System.currentTimeMillis();
                        BWwaitTime = 400;
                    }
                    backWheel = !backWheel;
                }
                //Position Checker
                if(vertSlide.getCurrentPosition()>=45){
                    vertSlideIn = true;
                }else{
                    vertSlideIn = false;
                }
                if(horizSlide.getCurrentPosition()<=170){
                    horizSlideIn = true;
                }else{
                    horizSlideIn = false;
                }
                if(wrist.getCurrentPosition()>=-130){
                    wristIn = true;
                }else{
                    wristIn = false;
                }
                if(vertSlide.getCurrentPosition()<=-3075){
                    vertSlideOut = true;
                }else{
                    vertSlideOut = false;
                }
                if(horizSlide.getCurrentPosition()>=1400){
                    horizSlideOut = true;
                }else{
                    horizSlideOut = false;
                }
                if(wrist.getCurrentPosition()<=-1400){
                    wristOut = true;
                }else{
                    wristOut = false;
                }


                //In/outtake Big Button Code
                //if(gamepad2.a && gp2A){
                //    outtakeMode2 = false;
                //    intakeMode = false;
                //    outtakeMode = !outtakeMode;
                //    if(outtakeMode = true){
                //        vertSlideMode = true;
                //        horizSlideMode = true;
                //        wristMode = true;
                //        wheelMode = true;
                //        basketMode = true;
                //    }
                //    gp2B = false;
                //}
                if(!gamepad2.a){
                    gp2A = true;
                }
                if(gamepad2.b && gp2B){
                    outtakeMode = false;
                    intakeMode = false;
                    outtakeMode2 = !outtakeMode2;
                    if(outtakeMode2 = true){
                        vertSlideMode = true;
                        horizSlideMode = true;
                        wristMode = true;
                        wheelMode = true;
                        basketMode = true;
                    }
                    gp2B = false;
                }
                if(!gamepad2.b){
                    gp2B = true;
                }
                if(gamepad2.y && gp2Y){
                    outtakeMode = false;
                    outtakeMode2 = false;
                    intakeMode = !intakeMode;
                    if(intakeMode = true){
                        vertSlideMode = true;
                        horizSlideMode = true;
                        wristMode = true;
                        wheelMode = true;
                        basketMode = true;
                    }
                    gp2Y = false;
                }
                if(!gamepad2.y){
                    gp2Y = true;
                }
                //A button
                if(outtakeMode){
                    if(!vertSlideIn&&vertSlideMode){
                        vertSlide.setPower(0.75);
                    }else{
                        vertSlideMode = false;
                    }
                    if(!wristIn&&wristMode&&vertSlideIn){
                        wrist.setPower(-0.5);
                    }else{
                        wristMode = false;
                    }
                    if(!horizSlideIn&&horizSlideMode&&wristOut&&vertSlideIn){
                        horizSlide.setPower(0.5);
                    }else{
                        horizSlideMode = false;
                    }

                    if(!horizSlideMode&&!wristMode&&!vertSlideMode){
                        outtakeMode = false;
                    }

                }
                //B button
                if(outtakeMode2){

                    if(!wristOut&&wristMode){
                        wrist.setPower(-0.5);
                    }else{
                        wristMode = false;
                    }
                    if(!vertSlideOut&&vertSlideMode&&wristOut){
                        vertSlide.setPower(-0.75);
                    }else{
                        vertSlideMode = false;
                    }
                    if(!horizSlideMode&&!wristMode&&!vertSlideMode){
                        outtakeMode2 = false;
                    }

                }
                //Y Button
                if(intakeMode){
                    if(!vertSlideIn&&vertSlideMode){
                        vertSlide.setPower(0.75);
                    }else{
                        vertSlideMode = false;
                    }
                    if(!wristOut&&wristMode&&horizSlideOut){
                        wrist.setPower(-0.5);
                    }else{
                        wristMode = false;
                    }
                    if(!horizSlideOut&&horizSlideMode){
                        horizSlide.setPower(0.5);
                    }else{
                        horizSlideMode = false;
                    }
                    if(!horizSlideMode&&!wristMode&&!vertSlideMode){
                        intakeMode = false;
                    }

                }

                //LED Code

                telemetry.addData("Time:", (System.currentTimeMillis()-LTime)/1000);
                telemetry.addData("verSlide:", vertSlide.getCurrentPosition());
                telemetry.addData("horizSlide:", horizSlide.getCurrentPosition());
                telemetry.addData("wrist:", wrist.getCurrentPosition());
                telemetry.addData("verSlideOut:", vertSlideOut);
                telemetry.addData("horizSlideOut:", horizSlideOut);
                telemetry.addData("wristOut:", wristOut);
                telemetry.addData("verSlideIn:", vertSlideIn);
                telemetry.addData("horizSlideIn:", horizSlideIn);
                telemetry.addData("wristIn:", wristIn);



                telemetry.update();
            }
            telemetry.update();
        }
    }}