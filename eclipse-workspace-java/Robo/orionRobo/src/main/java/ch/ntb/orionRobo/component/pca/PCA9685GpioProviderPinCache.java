/**
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.component.pca.PCA9685GpioProviderPinCache.java
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

/**
 * 
 */
import com.pi4j.io.gpio.GpioProviderPinCache;
import com.pi4j.io.gpio.Pin;


public class PCA9685GpioProviderPinCache extends GpioProviderPinCache {

    private int pwmOnValue = -1;
    private int pwmOffValue = -1;

    public PCA9685GpioProviderPinCache(Pin pin) {
        super(pin);
    }

    public int getPwmOnValue() {
        return pwmOnValue;
    }

    public void setPwmOnValue(int pwmOnValue) {
        this.pwmOnValue = pwmOnValue;
    }

    public int getPwmOffValue() {
        return pwmOffValue;
    }

    public void setPwmOffValue(int pwmOffValue) {
        this.pwmOffValue = pwmOffValue;
    }

    @Override
    public int getPwmValue() {
        throw new UnsupportedOperationException("Use getPwmOnValue() and getPwmOffValue() instead.");
    }

    @Override
    public void setPwmValue(int value) {
        throw new UnsupportedOperationException("Use setPwmOnValue() and setPwmOffValue() instead.");
    }
}
