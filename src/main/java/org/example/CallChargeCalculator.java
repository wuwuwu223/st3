package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CallChargeCalculator {
    public double calculateCharge(int durationInSeconds) {
        // 检查通话时间是否为负数
        if (durationInSeconds < 0) {
            throw new IllegalArgumentException("Invalid duration");
        }
        // 检查通话时间是否超过30小时（108000秒）
        if (durationInSeconds > 108000) {
            throw new IllegalArgumentException("Duration exceeds limit");
        }

        int durationInMinutes = (int) Math.ceil(durationInSeconds / 60.0); // 将秒数向上进位到分钟
        if (durationInMinutes <= 20) {
            return 0.05 * durationInMinutes;
        } else {
            return 1.00 + (0.10 * (durationInMinutes - 20));
        }
    }
}