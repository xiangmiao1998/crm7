<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/lqjs/customer.js"></script>
<div class="easyui-layout" data-options="fit:true" >
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="customercx">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户编号</th>
                <td><input id="cuNo"/></td>
                <th>名称</th>
                <td><input id="cuName"/></td>
                <th>地区</th>
                <td>
                    <select name="custRegion" id="cuRegion">
                        <option value="">全部</option>
                        <option value="北京">北京</option>
                        <option value="华北">华北</option>
                        <option value="中南">中南</option>
                        <option value="东北">东北</option>
                        <option value="西部">西部</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>客户经理</th>
                <td><input id="cuManagerName"/></td>
                <th>客户等级</th>
                <td>
                    <select name="custLevelLabel" id="cuLevelLabel">
                        <option value="">全部</option>
                        <option value="战略合作伙伴">战略合作伙伴</option>
                        <option value="合作伙伴">合作伙伴</option>
                        <option value="大客户">大客户</option>
                        <option value="普通客户">普通客户</option>
                    </select>
                </td>
                <th>　</th>
                <td>　</td>
            </tr>
        </table>
        <br />
        <table id="customer" class="easyui-datagrid">
        </table>
    </div>





    <div id="custd" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:550px;  padding:20px;">
        <form id="custf" method="post">
            <table class="query_form_table">
                <tr>
                    <th>客户编号</th>
                    <td><input name="custNo" id="custNo"></td>
                    <th>名称</th>
                    <td><input name="custName" id="custName" /><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>地区</th>
                    <td>
                        <select name="custRegion" id="custRegion">
                            <option>请选择...</option>
                            <option selected value="北京">北京</option>
                            <option value="华北">华北</option>
                            <option value="中南">中南</option>
                            <option value="东北">东北</option>
                            <option value="西部">西部</option>
                        </select>
                        <span class="red_star">*</span></td>
                    <th>客户经理</th>
                    <td>
                        <select name="custManagerName"  id="custManagerName">
                            <option>请选择...</option>
                            <option selected value="小明">小明</option>
                            <option value="旺财">旺财</option>
                            <option value="球球">球球</option>
                            <option value="孙小美">孙小美</option>
                            <option value="周洁轮">周洁轮</option>
                        </select><span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <th>客户等级</th>
                    <td>
                        <select name="custLevelLabel" id="custLevelLabel">
                            <option>请选择...</option>
                            <option selected value="战略合作伙伴">战略合作伙伴</option>
                            <option value="合作伙伴">合作伙伴</option>
                            <option value="大客户">大客户</option>
                            <option value="重点开发客户">重点开发客户</option>
                            <option value="普通客户">普通客户</option>
                        </select><span class="red_star">*</span>
                    </td>
                    <th>　</th>
                    <td>　</td>
                </tr>
                <tr>
                    <th>客户满意度</th>
                    <td>
                        <select name="custSatisfy" id="custSatisfy"><option value="">未指定</option>
                            <option value="5">☆☆☆☆☆</option>
                            <option value="4">☆☆☆☆</option>
                            <option value="3">☆☆☆</option>
                            <option value="2">☆☆</option>
                            <option value="1">☆</option></select><span class="red_star">*</span>
                    </td>
                    <th>客户信用度</th>
                    <td>
                        <select name="custCredit" id="custCredit"><option value="">未指定</option>
                            <option value="5">☆☆☆☆☆</option>
                            <option value="4">☆☆☆☆</option>
                            <option value="3">☆☆☆</option>
                            <option value="2">☆☆</option>
                            <option value="1">☆</option></select><span class="red_star">*</span>
                    </td>
                </tr>
            </table>
            <br />
            <table class="query_form_table">
                <tr>
                    <th>地址</th>
                    <td><input name="custAddr" id="custAddr"  /><span class="red_star">*</span>
                    </td>
                    <th>邮政编码</th>
                    <td><input id="custZip" name="custZip" size="20" /><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td>
                        <input id="custTel" name="custTel" size="20"  /><span class="red_star">*</span></td>
                    <th>传真</th>
                    <td>
                        <input id="custFax" name="custFax" size="20"  /><span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <th>网址</th>
                    <td>
                        <input id="custWebsite" name="custWebsite" size="20"  /><span class="red_star">*</span>
                    </td>
                    <th>　</th>
                    <td>　</td>
                </tr>
            </table>
            <br />
            <table class="query_form_table" id="table2">
                <tr>
                    <th>营业执照注册号</th>
                    <td><input id="custLicenceNo" name="custLicenceNo" size="20" /></td>
                    <th>法人</th>
                    <td><input id="custChieftain" name="custChieftain" size="20" /><span class="red_star">*</span>
                    </td>
                </tr>
                <tr>
                    <th>注册资金（万元）</th>
                    <td>
                        <input id="custBankroll" name="custBankroll" size="20" /> </td>
                    <th>年营业额</th>
                    <td>
                        <input id="custTurnover"  name="custTurnover" size="20" />
                    </td>
                </tr>
                <tr>
                    <th>开户银行</th>
                    <td>
                        <input id="custBank" name="custBank" size="20" /><span class="red_star">*</span>
                    </td>
                    <th>银行帐号</th>
                    <td><input id="custBankAccount" name="custBankAccount" size="20" /><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>地税登记号</th>
                    <td>
                        <input id="custLocalTaxNo" name="custLocalTaxNo" size="20" /></td>
                    <th>国税登记号</th>
                    <td><input id="custNationalTaxNo" name="custNationalTaxNo" size="20" /></td>
                </tr>
            </table>
        </form>
    </div>


















</div>
