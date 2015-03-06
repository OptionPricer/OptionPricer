/**
 * @author Sky
 * A class for Option.
 */
public class Option extends Product implements Cloneable {
    private OptionRight right;
    private OptionStyle style;

    public OptionRight getRight() {
        return right;
    }

    public void setRight(OptionRight right) {
        this.right = right;
    }

    public OptionStyle getStyle() {
        return style;
    }

    public void setStyle(OptionStyle style) {
        this.style = style;
    }

    @Override
    public Option clone() throws CloneNotSupportedException {
        Option newOpt = (Option) super.clone();
        newOpt.setStyle(this.getStyle());
        newOpt.setRight(this.getRight());
        return newOpt;
    }
}