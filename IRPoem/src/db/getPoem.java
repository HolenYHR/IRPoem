package db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.Poem;  

public class getPoem {
	
	public static String getList(int id){
        BufferedReader in = null;  
        try {  
            URL realUrl = new URL("http://"+Attr.attr.word2vecLink+"/?id="+id);  
            // 打开和URL之间的连接  
            URLConnection connection = realUrl.openConnection();  
            // 设置通用的请求属性  
            connection.setRequestProperty("accept", "*/*");  
            connection.setRequestProperty("connection", "Keep-Alive");  
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            connection.setConnectTimeout(5000);  
            connection.setReadTimeout(5000);  
            // 建立实际的连接  
            connection.connect();  
            // 定义 BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
            StringBuffer sb = new StringBuffer();  
            String line;  
            while ((line = in.readLine()) != null) {  
                sb.append(line);  
            }  
            return sb.toString();  
        } catch (Exception e) {  
            System.out.println("Exception occur when send http get request!");
            e.printStackTrace();
        }  
        // 使用finally块来关闭输入流  
        finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (Exception e2) {  
                e2.printStackTrace();  
            }  
        }  
        return null;  
	}
	
	public static Poem get(int id){
		Poem pm = new Poem();
		Connection conn=Database.getConnection();//获取数据库连接  
        //sql执行器对象  
        PreparedStatement ps=null;  
        //结果集对象  
        ResultSet rs=null;//查询出来的数据先放到rs中  
        try{  
              String sql="select * from my_poem where id ="+id;  
              ps=conn.prepareStatement(sql);  
              rs=ps.executeQuery();//执行数据库查询的方法，放到rs中  
              while(rs.next()){//rs对象相当于一个指针，指向数据库的一横行数据  
                  pm = new Poem(Integer.parseInt(rs.getString("id")),rs.getString("name"),rs.getString("chaodai"),rs.getString("zuozhe"),rs.getString("content"));
                  
              }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{//重点下面代码必须写，当数据库使用后必须关闭，如果没有关闭数据库的接口有限，下次就不能连接  
            try{  
                if(rs!=null){  
                    rs.close();  
                }if(ps!=null){  
                    ps.close();  
                }if(conn!=null){  
                    conn.close();  
                }  
            }catch(Exception e2){  
                e2.printStackTrace();  
            }  
        } 
        return pm;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = getList(1);
		System.out.println(s);
		Poem p = get(1);
		System.out.println(p.getContent());
	}

}
