package dongman;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.SQLException;
import java.util.Map;

public class DMPipeline implements Pipeline {
    DMJDBC jdbc=new DMJDBC();
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String,Object> all=resultItems.getAll();
        DMInfo dmInfo=new DMInfo();
        for (String s: all.keySet()){
            dmInfo =(DMInfo)all.get(s);
            try {
                jdbc.save(dmInfo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
