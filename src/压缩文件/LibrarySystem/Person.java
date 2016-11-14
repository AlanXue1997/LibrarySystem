package LibrarySystem;

/**
 * ������һ���˵���Ϣ������id�����ͣ�ѧ��\����Ա��������������ͼ���isbn�루3����������ͼ���ʱ�䣨3����
 * @author Alan
 *
 */
public class Person {
	
	/**
	 * ��������֮һ����ʾѧ����ֵΪ0
	 */
	public static int STUDENT = 0;
	/**
	 * ��������֮һ����ʾ����Ա��ֵΪ1
	 */
	public static int MANAGER = 1;
	
	private String id = "";
	private int idType = 0;
	private String name = "";
	private String lentA = "0";
	private String lentB = "0";
	private String lentC = "0";
	private int lentADate = -1;
	private int lentBDate = -1;
	private int lentCDate = -1;

	/**
	 * ����id��ֻ�����û�ע��ʱ���ɣ�
	 * @param id ע�����ַ�������������
	 */
	public void setId(String id) { this.id = id; }
	/**
	 * ������������
	 * @param idType ���������
	 */
	public void setIdType(int idType) { this.idType = idType; }
	/**
	 * ��������
	 * @param name ����
	 */
	public void setName(String name) { this.name = name; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentA
	 */
	public void setLentA(String lentA) { this.lentA = lentA; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentB
	 */
	public void setLentB(String lentB) { this.lentB = lentB; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentC
	 */
	public void setLentC(String lentC) { this.lentC = lentC; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentADate
	 */
	public void setLentADate(int lentADate) { this.lentADate = lentADate; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentBDate
	 */
	public void setLentBDate(int lentBDate) { this.lentBDate = lentBDate; }
	/**
	 * ֻ����LibraryDatabase�ڲ�
	 * @param lentCDate
	 */
	public void setLentCDate(int lentCDate) { this.lentCDate = lentCDate; }

	/**
	 * ��ȡid
	 * @return �����id
	 */
	public String getId() { return id; }
	/**
	 * ��ȡ��������
	 * @return ���������
	 */
	public int getIdType() { return idType; }
	/**
	 * ��ȡ����
	 * @return ���������
	 */
	public String getName() { return name; }
	/**
	 * ��ȡ�����ĵ�һ�����isbn��
	 * @return �����˽��˵�һ���飬�򷵻����isbn�룬���򷵻�"0"
	 */
	public String getLentA() { return lentA; }
	/**
	 * ��ȡ�����ĵڶ������isbn��
	 * @return �����˽��˵ڶ����飬�򷵻����isbn�룬���򷵻�"0"
	 */
	public String getLentB() { return lentB; }
	/**
	 * ��ȡ�����ĵ��������isbn��
	 * @return �����˽��˵������飬�򷵻����isbn�룬���򷵻�"0"
	 */
	public String getLentC() { return lentC; }
	/**
	 * ��ȡ������һ���������
	 * @return �����˽��˵�һ���飬�򷵻����ڣ����򷵻�ֵ��ȷ��
	 */
	public int getLentADate() { return lentADate; }
	/**
	 * ��ȡ�����ڶ����������
	 * @return �����˽��˵ڶ����飬�򷵻����ڣ����򷵻�ֵ��ȷ��
	 */
	public int getLentBDate() { return lentBDate; }
	/**
	 * ��ȡ�����������������
	 * @return �����˽��˵������飬�򷵻����ڣ����򷵻�ֵ��ȷ��
	 */
	public int getLentCDate() { return lentCDate; }
	
}
