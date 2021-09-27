package fadelKmartPK;


/**
 * Write a description of class Transactor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Transactor
{
    public boolean validate();
    public Invoice perform();
}
