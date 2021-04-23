package tubes;

import java.util.ArrayList;

public class Lapras extends Engimon{
    public Lapras(String name, Coordinate pos, int level) {
        super(name, "Lapras", "Water", "Ice", "Duar lulus (amin)", pos, level);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Water"); element.add("Ice");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,75,1,"Frozen");
        this.incSkills(newSkill);
    }
}
