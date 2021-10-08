package taskB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + getName());
    }
}
