<#-- 自定义的分页指令。
属性说明：
   pageNo      当前页号(int类型)
   totalPage   总页码数(int类型)
   toURL       点击分页标签时要跳转到的目标URL(string类型)
 使用方式：
  <#if recordCount??>
    <#import "/pager.ftl" as p>
    <@p.pager pageNo=1 pageSize=10 recordCount=13 pageCount=2 toURL="xxxxx/queryXXX" method="get"/>
  </#if>
 -->

<#macro pager pageNo totalPage toURL>
<#-- 页号越界处理 -->
    <#if (pageNo > totalPage)>
        <#assign pageNo=totalPage>
    </#if>
    <#if (pageNo < 1)>
        <#assign pageNo=1>
    </#if>
<#-- 输出分页表单 -->
<#--**********************************************************************************-->
<form method="GET" action="" name="qPagerForm">
    <ul class="pagination">
        <#if (pageNo == 1)>
            <li class="disabled">
                <a href="javascript:void(0)">首页</a>
            </li>
            <li class="disabled">
                <a href="javascript:void(0)">上一页</a>
            </li>
        <#else>
            <li>
                <a href="javascript:void(0)" onclick="turnOverPage(1)">首页</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="turnOverPage(${pageNo - 1})">上一页</a>
            </li>
        </#if>

    <#-- totalPage <= 5 -->
        <#if (totalPage <= 5)>
            <#list 1..totalPage as i>
                <#if (pageNo == i)>
                    <li class="active">
                        <a href="javascript:void(0)" onclick="turnOverPage(${i})">${i}</a>
                    </li>
                <#else>
                    <li>
                        <a href="javascript:void(0)" onclick="turnOverPage(${i})">${i}</a>
                    </li>
                </#if>
            </#list>
        <#else>
            <#assign done=0>
            <#assign left=-2>
            <#assign right=2>
            <#if (pageNo <= 2)>
                <#assign left = (1 - pageNo)>
                <#assign right = (5 - pageNo)>
            <#elseif (pageNo > 2 && pageNo < (totalPage -2))>
                <#assign left = -2>
                <#assign right = 2>
            <#elseif (pageNo >= totalPage - 2)>
                <#assign left = (totalPage - pageNo - 4)>
                <#assign right = (totalPage - pageNo)>
            </#if>

            <#list left..right as i>
                <#if ((pageNo + i > 0) && (pageNo + i <= totalPage))>
                    <#if (pageNo == (pageNo + i))>
                        <li class="active">
                            <a href="javascript:void(0)" onclick="turnOverPage(${pageNo + i})">${pageNo + i}</a>
                        </li>
                    <#else>
                        <li>
                            <a href="javascript:void(0)" onclick="turnOverPage(${pageNo + i})">${pageNo + i}</a>
                        </li>
                    </#if>
                    <#assign done=done+1>
                </#if>

                <#if (done == 5)>
                    <#break>
                </#if>
            </#list>
        </#if>

        <#if (pageNo == totalPage)>
            <li class="disabled">
                <a href="javascript:void(0)">下一页</a>
            </li>
            <li class="disabled">
                <a href="javascript:void(0)">尾页</a>
            </li>
        <#else>
            <li>
                <a href="javascript:void(0)" onclick="turnOverPage(${pageNo + 1})">下一页</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="turnOverPage(${totalPage})">尾页</a>
            </li>
        </#if>
    </ul>
</form>
<#--**********************************************************************************-->
<script language="javascript">
    function turnOverPage(no) {
        var qForm = document.qPagerForm;
        if (no >${totalPage}) {
            no =${totalPage};
        }
        if (no < 1) {
            no = 1;
        }
//        qForm.page.value = no;
        qForm.action = "${toURL}" + no;
        qForm.submit();
    }
</script>

</#macro>