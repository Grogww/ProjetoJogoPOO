package game;

public class Combatente extends Personagem{

    public Combatente(String name){
        this.name = name;
        this.level = 3;
        specialUnlocked = false;
        hpBase = 35;
        powBase = 14;
        defBase = 5;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " pega sua cimitarra e investe contra " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " se protege com sua cimitarra!");
    }

    @Override
    public void useSpecial(Personagem target) {
    }

    @Override
    public void levelUp(){
        resetStatus();
    }
}