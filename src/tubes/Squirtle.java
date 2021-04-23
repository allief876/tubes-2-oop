package tubes;

import java.util.ArrayList;

public class Squirtle extends Engimon {
    public Squirtle(String name, Coordinate pos, int level) {
        super(name, "Squirtle", "Water", "none", "Plis kasih nilai bagus ya :)", pos, level);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Water"); element.add("none");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,75,1,"Waterfall");
        this.incSkills(newSkill);
    }
}