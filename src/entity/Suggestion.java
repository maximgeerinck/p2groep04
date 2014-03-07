package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class Suggestion implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private User user;
	private String subject;
	private ResearchDomain researchDomain;

	
}