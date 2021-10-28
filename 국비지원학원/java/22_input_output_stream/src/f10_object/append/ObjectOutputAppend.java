package f10_object.append;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputAppend extends ObjectOutputStream{
	public ObjectOutputAppend(OutputStream out) throws IOException{
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// 헤더 저장 할때 아무것도 하지 않기.
	}
}










