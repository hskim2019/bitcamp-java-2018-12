package after2;

public class EngineOilCarObserver implements CarObserver{

  @Override
  public void carStarted() {
    System.out.println("엔진 오일 유무 검사");
    
  }

  @Override
  public void carStopped() {
    // TODO Auto-generated method stub
    
  }

}
