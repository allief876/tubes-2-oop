package tubes;

import java.util.ArrayList;

public class Rotom extends Engimon{
    public Rotom(String name, Coordinate pos, int level, Boolean isWildEngimon) {
        super(name, "Rotom", "Fire", "Electric", "Siap begadang demi tubes", pos, level, isWildEngimon);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Fire"); element.add("Electric");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,75,1,"Overloaded");
        this.incSkills(newSkill);
    }
}