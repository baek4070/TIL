package member;

import java.util.Date;
// 기존 멤버에서 삭제 날짜만 추가하면 되니까 상속을 받자 ! 
public class BackUpMember extends Member {
	
	private Date deleteDate;

	
	
	public BackUpMember(int mNum, String mName, String mId, String mPw, long reg, Date deleteDate) {
		super(mNum, mName, mId, mPw, reg);
		this.deleteDate = deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	@Override
	public String toString() {
		return super.toString()+"BackUpMember [deleteDate=" + deleteDate + "]";
	}
	
}
