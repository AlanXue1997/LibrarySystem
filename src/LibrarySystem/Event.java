package LibrarySystem;

/**
 * ������һ���¼�����Ϣ���������ڡ����͡����isbn�롢������id������Աid��֮ǰ����öȡ�֮�����ö�
 * ������set������ֻ��LibraryDatebase�ڲ�ʹ�ã��ⲿ����Ҫʹ�ã�
 * @author Alan
 *
 */
public class Event {
	
	/**
	 * �¼�������֮һ����ʾ���飬ֵΪ0
	 */
	public static int BORROW = 0;
	/**
	 * �¼�������֮һ����ʾ���飬ֵΪ1
	 */
	public static int RETURN = 1;
	/**
	 * �¼�������֮һ����ʾ���裬ֵΪ2
	 */
	public static int RENEW = 2;
	/**
	 * �¼�������֮һ����ʾ���裬ֵΪ3
	 */
	public static int ORDER = 3;
	
	private int id;
	private int date;
	private int type;
	private String isbn;
	private String userId;
	private String managerId;
	private double beforeIntegrity;
	private double afterIntegrity;
	
	public void setId(int id) { this.id = id; }
	public void setDate(int date) { this.date = date; }
	public void setType(int type) { this.type = type; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setUserId(String userId) { this.userId = userId; }
	public void setManagerId(String managerId) { this.managerId = managerId; }
	public void setBeforeIntegrity(double beforeIntegrity) { this.beforeIntegrity = beforeIntegrity; }
	public void setAfterIntegrity(double afterIntegrity) { this.afterIntegrity = afterIntegrity; }

	/**
	 * ��ȡ�¼������
	 * @return һ����ˮ�ţ����ԱȽϷ���ıȽ��¼��������Ⱥ�˳��
	 */
	public int getId() { return id; };
	/**
	 * ��ȡ�¼���ʱ��
	 * @return һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706��
	 */
	public int getDate() { return date; };
	/**
	 * ��ȡ�¼�������
	 * @return �¼�������
	 */
	public int getType() { return type; };
	/**
	 * ��ȡ�¼�����Ӧ�����isbn��
	 * @return ���isbn��
	 */
	public String getIsbn() { return isbn; };
	/**
	 * ��ȡ�¼�����Ӧ�Ľ����ߵ�id
	 * @return �����ߵ�id
	 */
	public String getUserId() { return userId; }
	/**
	 * ��ȡ�¼�����Ӧ�Ĺ���Ա��id
	 * @return ����¼�����ΪBORROW��RETURN�����ع���Ա��id������¼�����ΪRENEW,���ؿ��ַ���""
	 */
	public String getManagerId() { return managerId; }
	/**
	 * ��ȡ�¼�����֮ǰ�����ó̶�
	 * @return ����¼�����ΪRETURN������0~1֮���һ��ʵ��������¼�����ΪBORROW��RENEW������-1
	 */
	public double getBeforeIntegrity() { return beforeIntegrity; }
	/**
	 * ��ȡ�¼�����֮�������ó̶�
	 * @return ����¼�����ΪRETURN������0~1֮���һ��ʵ��������¼�����ΪBORROW��RENEW������-1
	 */
	public double getAfterIntegrity() { return afterIntegrity; }

}
