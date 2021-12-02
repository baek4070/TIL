package fx_client_catch.game;

import fx_client_catch.vo.PaintVO;

public interface GameInterface {
	//vo 객체를 수신 
	public void receiveData(PaintVO vo);
	//vo를 넘겨받아 그림을 그리는 메소드
	public void Painting(PaintVO vo);
	//캔버스 초기화
	public void ResetCanvas();
}
