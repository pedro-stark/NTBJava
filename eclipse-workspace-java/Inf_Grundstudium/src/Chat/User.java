package Chat;

import java.io.Serializable;
import javax.swing.*;

public class User implements Serializable, Comparable<User>
{
    private static final long serialVersionUID = 83833643L;

    private String name;
    private Icon icon = null;

    public User(String name)
    {
        this.name = name;
    }

    public User(String name, Icon icon)
    {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    public String toString()
    {
        return name;
    }

    public int compareTo(User u) {
        // only the name is important
        return this.name.compareTo(u.name);
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        User u = (User) o;
        // field comparison
        return name.equals(u.name);
    }
}
