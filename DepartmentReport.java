public class DepartmentReport implements Runnable{
    private String departmentName;

    public DepartmentReport(String name){
        this.departmentName = name;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is generating report "+departmentName+" Report");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Generating report interupted");
            return ;
        }

        System.out.println(departmentName + " department report generated.");

    }

}
