package com.wei.activiti;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Shenzhiwei
 * @Desicription:查询流程图
 * @Date:Created in 2018-07-04 14:53
 * @Modified By:
 */
@Controller
public class ProcessDiagramController {


    @RequestMapping ( value = "/api/inform", method = RequestMethod.GET )
    public String getDiagram(HttpServletResponse response) throws Exception {
        OutputStream out = null;
        try {
            InputStream is = this.getDiagram("12501");
            BufferedInputStream reader = new BufferedInputStream(is);
            BufferedOutputStream writer = new BufferedOutputStream(response.getOutputStream());
            byte[] bytes = new byte[1024 * 1024];
            int length = reader.read(bytes);
            while ((length > 0)) {
                writer.write(bytes, 0, length);
                length = reader.read(bytes);
            }
            reader.close();
            writer.close();
            response.setContentType("multipart/form-data;charset=utf8");
            out = response.getOutputStream();
            out.write(getImgByte(is));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    private byte[] getImgByte(InputStream is) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int b;
        while ((b = is.read()) != -1) {
            byteArrayOutputStream.write(b);
        }
        byte[] bs = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return bs;
    }

    public InputStream getDiagram(String processId) {
        ProcessEngine engines = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engines.getRepositoryService();
        RuntimeService runtimeService = engines.getRuntimeService();
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
        BpmnModel model = repositoryService.getBpmnModel(pd.getId());
        String fontName = "宋体";
        List<String> current = runtimeService.getActiveActivityIds(pi.getId());
        InputStream is = engines.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(model, "png", current, new ArrayList<String>(), fontName, fontName, fontName, null, 1.0);
        return is;
    }
}
