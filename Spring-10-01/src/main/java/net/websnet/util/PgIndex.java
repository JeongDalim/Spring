package net.websnet.util;


public class PgIndex {
   public static String pageList(int page,int totpage,String url,String addtag) {
        int idx_pre, idx_start;
        
        String s_home = "";   // ù�������� �̵�
        String s_pre = "";    // Prev ���� ����
        String s_idx = "";    // ��ȣ ���� ����
        String s_next = "";   // Next ���� ����
        String s_end = "";    // ������ �������� �̵�

        idx_start = ((page-1) / 10) * 10 + 1 ;  // ���� ������ ���
        idx_pre = ((page-1) / 10);              // Priview ������ ���

   /*   // ù�������� �̵�
      if(page == 1) {
           s_home = " [Home] ";
        } else {
           s_home = " <a href='"+url+"?page=1"+addtag+"'>[Home]</a> ";
        }
   */
        // Prev ǥ�� �κ�
        if(idx_pre > 0) {
           s_pre = "<a href='"+url+"?page="+(idx_pre*10)+addtag+"'><img src=/img/i_prev.gif width=30 height=7></a>";
        } else {
           s_pre = "<img src=/img/i_prev.gif width=30 height=7> ";
        }

        // ��ȣ ǥ�úκ�   
        for(int i=0;i<5;i++,idx_start++) {
           if(idx_start>totpage) break;
           if(idx_start == page)
              s_idx = s_idx + " "+idx_start+" ";
           else {
              s_idx = s_idx + " <a href='" + url + "?page=" + idx_start;
              s_idx = s_idx + addtag + "'> " + idx_start + " </a> ";
           }
        }

         // Next ǥ�úκ�
        if(idx_start <= totpage ) {
           s_next = "<a href='"+url+"?page="+idx_start+addtag+"'><img src=/img/i_next.gif width=30 height=7></a>";
        } else {
           s_next = " <img src=/img/i_next.gif width=30 height=7>";
        }

   /*   // �������������� �̵�
      if(page == totpage) {
           s_end = " [End] ";
        } else {
           s_end = " <a href='"+url+"?page="+totpage+addtag+"'>[End]</a> ";
        }
   */
        String outHtml = s_home + s_pre + s_idx + s_next + s_end;  // Html �� ����
        return outHtml;
     }

}