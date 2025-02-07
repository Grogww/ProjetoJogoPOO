package game;

public abstract class Personagem {
    protected String name;
    protected int hpBase;
    protected int hp;
    protected int powBase;
    protected int pow;
    protected int defBase;
    protected int def;
    protected int level;
    protected boolean specialUnlocked;

    /* ESTRUTURAS A SEREM HERDADAS */

    protected abstract void attack(Personagem target);

    protected abstract void defend();

    protected abstract void useSpecial(Personagem target);

    protected abstract void levelUp();
    
    protected void heal(){

    }
    
    /* ESTRUTURAS FIXAS */

    public void receiveDamage(int dano) {
        hp -= Math.max(0, dano - def);
    }
    
    public boolean isDead(){
        return (hp <= 0);
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getHpBase(){
        return hpBase;
    }

    public Boolean isSpecialUnlocked(){
        return specialUnlocked;
    }

    public void resetStatus(){
        //resetar status
        this.hp = this.hpBase;
        this.pow = this.powBase;
        this.def = this.defBase;
    }

    public void resetDef(){
        //resetar defesa começo do round
        this.def = this.defBase;
    }

    
}
