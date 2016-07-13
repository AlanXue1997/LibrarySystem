package LibrarySystem;

/**
 * ������һ�������Ϣ���࣬����isbn�롢���������ߡ������硢�������ڡ���ó̶ȡ��Ƿ�������˭�����������ڡ��Ƿ�Ԥ������˭Ԥ����Ԥ������
 * ���У�����isbn����ó̶ȡ��Ƿ������Ƿ�Ԥ��������Ϣ��Ϊ��
 * @author Alan
 *
 */
public class Book {
	
	private String isbn = "";
	private String name = "";
	private String author = "";
	private String press = "";
	private int publicationDate = -1;
	private double integrity = -1;
	private boolean lent = false;
	private String lentPerson = "";
	private int lentDate = -1;
	private boolean ordered = false;
	private String orderedPerson = "";
	private int orderedDate = -1;

	/**
	 * �������isbn��
	 * @param isbn ע�����ַ�������������
	 */
	public void setIsbn(String isbn) { this.isbn = isbn; }
	/**
	 * ����������Ĭ��Ϊ���ַ���""��
	 * @param name
	 */
	public void setName(String name) { this.name = name; }
	/**
	 * �������ߣ�Ĭ��Ϊ���ַ���""��
	 * @param author
	 */
	public void setAuthor(String author) { this.author = author; }
	/**
	 * ���ó����磨Ĭ��Ϊ���ַ���""��
	 * @param press
	 */
	public void setPress(String press) { this.press = press; }
	/**
	 * ���ó���ʱ�䣨Ĭ��Ϊ-1��
	 * @param publicationDate һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706���������ڲ��������ֵ�ĺϷ��Խ����ж�
	 */
	public void setPublicationDate(int publicationDate) { this.publicationDate = publicationDate; }
	/**
	 * ������ó̶ȣ�Ĭ��Ϊ-1����һ�����Ϸ���ֵ��
	 * @param integrity ��ֵӦ����0~1֮�䣨�����ڲ��������ֵ�ĺϷ��Խ����жϣ�
	 */
	public void setIntegrity(double integrity) { this.integrity = integrity; }
	/**
	 * �����Ƿ񱻽���������������Ӧ����������lentPerson��lentDate����δ�������lentPerson��lentDate��ֵ���迼��
	 * @param lent ���Ϊtrue��δ�����Ϊfalse
	 */
	public void setLent(boolean lent) { this.lent = lent; }
	/**
	 * ���ý�����ˣ���id��
	 * @param id �����˵�id
	 */
	public void setLentPerson(String id) { lentPerson = id; }
	/**
	 * ���ý��ʱ�䣨Ĭ��Ϊ-1��
	 * @param lentDate һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706���������ڲ��������ֵ�ĺϷ��Խ����ж�
	 */
	public void setLentDate(int lentDate) { this.lentDate = lentDate; }
	/**
	 * �����Ƿ�Ԥ��������Ԥ������Ӧ����������orderedPerson��orderedDate����δ�������orderedPerson��orderedDate��ֵ���迼��
	 * @param ordered Ԥ��Ϊtrue��δ��Ԥ��Ϊfalse
	 */
	public void setOrdered(boolean ordered) { this.ordered = ordered; }
	/**
	 * ����Ԥ�����ˣ���id��
	 * @param id Ԥ�����˵�id
	 */
	public void setOrderedPerson(String id) { orderedPerson = id; }
	/**
	 * ����Ԥ��ʱ�䣨Ĭ��Ϊ-1��
	 * @param orderedDate һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706���������ڲ��������ֵ�ĺϷ��Խ����ж�
	 */
	public void setOrderedDate(int orderedDate) { this.orderedDate = orderedDate; }

	/**
	 * ��ȡ���isbn��
	 * @return ���isbn�� 
	 */
	public String getIsbn() { return isbn; }
	/**
	 * ��ȡ����
	 * @return ��������û����������Ϊ���ַ���""��
	 */
    public String getName() { return name; }
    /**
     * ��ȡ����
     * @return ���ߣ���û�����ߣ���Ϊ���ַ���""��
     */
    public String getAuthor() { return author; }
    /**
     * ��ȡ������
     * @return �����磨��û�г����磬��Ϊ���ַ���""��
     */
    public String getPress() { return press; }
    /**
     * ��ȡ����ʱ��
     * @return ����ʱ�䣬һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706������û�г���ʱ�䣬�򷵻�-1
     */
    public int getPublicationDate() { return publicationDate; }
    /**
     * ��ȡ�����ó̶�
     * @return 0~1֮���һ��ʵ��
     */
    public double getIntegrity() { return integrity; }
    /**
     * ��ȡ���Ƿ񱻽��
     * @return ���Ϊtrue��δ�����Ϊfalse
     */
    public boolean getLent() { return lent; }
    /**
     * ��ȡ��������
     * @return ���鱻�������Ϊ�����˵�id������δ��������򷵻����ݲ�ȷ��
     */
    public String getLentPerson() { return lentPerson; }
    /**
     * ��ȡ����������
     * @return ������ڣ�һ��8λ��������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706������û�н�����򷵻����ֲ�ȷ��
     */
    public int getLentDate() { return lentDate; }
    /**
     * ��ȡ���Ƿ�Ԥ��
     * @return Ԥ��Ϊtrue��δ��Ԥ��Ϊfalse
     */
    public boolean getOrdered() { return ordered; }
    /**
     * ��ȡԤ�������
     * @return ���鱻Ԥ������ΪԤ���˵�id������δ��Ԥ�����򷵻����ݲ�ȷ��
     */
    public String getOrderedPerson() { return orderedPerson; }
    /**
     * ��ȡԤ���������
     * @return Ԥ�����ڣ�һ��8λ������ʽΪyyyymmdd������2016��7��6��ӦдΪ20160706������û��Ԥ�����򷵻����ֲ�ȷ��
     */
    public int getOrderedDate() { return orderedDate; }

}
