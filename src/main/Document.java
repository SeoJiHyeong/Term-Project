import java.util.Iterator;
import java.util.ArrayList;

class Document implements MDElement{
 	private ArrayList document = new ArrayList();
 	private ArrayList temp = new ArrayList();
	private ArrayList nodes = new ArrayList();
	private ArrayList multipleLineCase = new ArrayList();
	private ArrayList nodeSyntax = new ArrayList();
	ArrayList<String> hi;
	
    public Document() {
		//for(int i=1;i<7;i++)whes.add(new Wheel(String.valueOf(i)));
    	nodeSyntax.add(new Header());
    
    }
    public void accept(MDElementVisitor v){
    	v.visit(this);
    	Iterator it = nodeSyntax.iterator();
    	while(it.hasNext()){
    		Node next = (Node)it.next();
    		next.accept(v);
    	}
    }
    
    public ArrayList<String> getDocuments(){
    	hi = new ArrayList<String>();
    	return hi;
    	
    }
    
    public void addDocument(String line){
    	document.add(line);
    	//checkSyntax(line);
    }
    public void checkSyntax(String line){
    	Iterator it = multipleLineCase.iterator();
    	Boolean isMultiple = false;
    	String next;
    	while(it.hasNext()){
    		next = (String)it.next();
    		if((line.equals(next))){
    			isMultiple = true;
    			break;
    		}
    	}
    	if(isMultiple==false);
    		//addNode(line);
    }
    public ArrayList getDocument(){
    	return document;
    }
    
    public void addNode(Node n){
    	nodes.add(n);
    }
    /*
    public void accept(Mv Visitor visitor) {
		System.out.print("Checking Wheels...");
		Iterator it = whes.iterator();
        while (it.hasNext()) {
            Wheel whe = (Wheel)it.next();
			whe.accept(visitor);
        }
		System.out.print("OK\n");
		System.out.print("Checking Cameras...");
		it = cams.iterator();
        while (it.hasNext()) {
            Camera cam = (Camera)it.next();
			cam.accept(visitor);
        }
		System.out.print("OK\n");
		System.out.print("Checking Arms...");
		it = arms.iterator();
        while (it.hasNext()) {
            Arm arm = (Arm)it.next();
			arm.accept(visitor);
        }
		System.out.print("OK\n");
		System.out.print("Checking Batteries...");
		it = bats.iterator();
        while (it.hasNext()) {
            Battery bat = (Battery)it.next();
			bat.accept(visitor);
        }
		System.out.print("OK\n");
		System.out.print("Checking Mortors...");
		it = mors.iterator();
        while (it.hasNext()) {
            Motor mor = (Motor)it.next();
			mor.accept(visitor);
        }
		System.out.print("OK\n");
		System.out.print("Checking Solar Energy Collector...");
		it = cols.iterator();
        while (it.hasNext()) {
            SolarEnergyCollector col = (SolarEnergyCollector)it.next();
			col.accept(visitor);
        }
		System.out.print("OK\n");
    }
}

class Wheel implements RoverComponent{
    private String name;
    public Wheel(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }
}
class Motor implements RoverComponent{
    private String name;
    public Motor(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }
}
class Arm implements RoverComponent{
    private String name;
    public Arm(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }
}
class Battery implements RoverComponent{
    private String name;
    public Battery(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }
}
class Camera implements RoverComponent{
    private String name;
    public Camera(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }
}
class SolarEnergyCollector implements RoverComponent{
    private String name;
    public SolarEnergyCollector(String name) {
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
	public String getName() {
        return this.name;
    }*/
}