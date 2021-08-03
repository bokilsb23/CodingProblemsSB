package com.sb.design_patterns;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    private Lizard lizard;
    private Bird bird;

    public Dragon(){}

    public Dragon( Lizard lizard, Bird bird, int age){
        this.age = age;
        this.bird = bird;
        this.lizard = lizard;
    }


    public void setAge(int age)
    {
        this.age = age;
        if(this.bird != null){
            this.bird.age = age;
        }
        if(this.lizard != null){
            this.lizard.age = age;
        }

    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}