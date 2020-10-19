/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.component.pca.PCA9685Pin.java
 * 
 * @author Basile Schoeb <basile.schoeb@ntb.ch>
 * 
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Copyright (c) 2018 NTB Systemtechnikprojekt Team 7
 */
package ch.ntb.orionRobo.component.pca;

import java.util.EnumSet;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.impl.PinImpl;

public class PCA9685Pin {

    public static final Pin PWM_00 = createPwmPin(0, "PWM 0");
    public static final Pin PWM_01 = createPwmPin(1, "PWM 1");
    public static final Pin PWM_02 = createPwmPin(2, "PWM 2");
    public static final Pin PWM_03 = createPwmPin(3, "PWM 3");
    public static final Pin PWM_04 = createPwmPin(4, "PWM 4");
    public static final Pin PWM_05 = createPwmPin(5, "PWM 5");
    public static final Pin PWM_06 = createPwmPin(6, "PWM 6");
    public static final Pin PWM_07 = createPwmPin(7, "PWM 7");
    public static final Pin PWM_08 = createPwmPin(8, "PWM 8");
    public static final Pin PWM_09 = createPwmPin(9, "PWM 9");
    public static final Pin PWM_10 = createPwmPin(10, "PWM 10");
    public static final Pin PWM_11 = createPwmPin(11, "PWM 11");
    public static final Pin PWM_12 = createPwmPin(12, "PWM 12");
    public static final Pin PWM_13 = createPwmPin(13, "PWM 13");
    public static final Pin PWM_14 = createPwmPin(14, "PWM 14");
    public static final Pin PWM_15 = createPwmPin(15, "PWM 15");

    public static final Pin[] ALL = {
            PCA9685Pin.PWM_00,
            PCA9685Pin.PWM_01,
            PCA9685Pin.PWM_02,
            PCA9685Pin.PWM_03,
            PCA9685Pin.PWM_04,
            PCA9685Pin.PWM_05,
            PCA9685Pin.PWM_06,
            PCA9685Pin.PWM_07,
            PCA9685Pin.PWM_08,
            PCA9685Pin.PWM_09,
            PCA9685Pin.PWM_10,
            PCA9685Pin.PWM_11,
            PCA9685Pin.PWM_12,
            PCA9685Pin.PWM_13,
            PCA9685Pin.PWM_14,
            PCA9685Pin.PWM_15};

    private static Pin createPwmPin(int channel, String name) {
        return new PinImpl(PCA9685GpioProvider.NAME, channel, name, EnumSet.of(PinMode.PWM_OUTPUT));
    }
}
