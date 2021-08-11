package study.jcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {

  final App app = new App();

  @Test
  @DisplayName("그냥 해 본 덧셈 테스트. 이렇게 테스트 작성해요.")
  void shouldRunWithoutError() {
    final int sum = app.sum(1, 2);

    assertEquals(3, sum);
  }

}
