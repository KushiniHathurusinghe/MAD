package com.mad.mad;

public class User
{

    //student
    private String id;
    private String index;
    private String name;
    private String email;
    private String phone;
    private String GPA;
    private String batch;
    private String password;


    // lecturer

    private String idLect;
    private String indexLect;
    private String nameLect;
    private String emailLect;
    private String passwordLect;


    //task

    private String idTask ;
    private String nametask;
    private String subjectTask;
    private String batchTask;
    private String emailTask;




    //Student

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }


    public String getIndex()
    {
        return index;
    }
    public void setIndex(String index)
    {
        this.index=index;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }


    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }


    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }


    public String getGPA()
    {
        return GPA;
    }
    public void setGPA(String GPA)
    {
        this.GPA=GPA;
    }


    public String getBatch()
    {
        return batch;
    }
    public void setBatch(String batch)
    {
        this.batch=batch;
    }


    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }



    //lecturer

    public String getLectId()
    {
        return idLect;
    }
    public void setLectId(String idLect) { this.idLect=idLect; }


    public String getLectIndex()
    {
        return indexLect;
    }
    public void setLectIndex(String indexLect) { this.indexLect=indexLect; }

    public String getLectName()
    {
        return nameLect;
    }
    public void setLectName(String nameLect)
    {
        this.nameLect=nameLect;
    }


    public String getLectEmail()
    {
        return emailLect;
    }
    public void setLectEmail(String emailLect)
    {
        this.emailLect=emailLect;
    }


    public String getLectPassword()
    {
        return passwordLect;
    }
    public void setLectPassword(String passwordLect)
    {
        this.passwordLect=passwordLect;
    }





    //task

    public String getTaskId()
    {
        return idTask;
    }
    public void setTaskId(String idTask) { this.idTask=idTask; }


    public String getTaskName() { return nametask; }
    public void setTaskName(String nametask)
    {
        this.nametask=nametask;
    }


    public String getTaskSubject()
    {
        return subjectTask;
    }
    public void setTaskSubject(String subjectTask) { this.subjectTask=subjectTask; }

    public String getTaskBatch()
    {
        return batchTask;
    }
    public void setTaskBatch(String batchTask)
    {
        this.batchTask=batchTask;
    }


    public String getTaskEmail()
    {
        return emailTask;
    }
    public void setTaskEmail(String emailTask)
    {
        this.emailTask=emailTask;
    }







}
