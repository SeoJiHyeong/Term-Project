package md;
public interface MDElement {
	void accept(MDElementVisitor v);
}
