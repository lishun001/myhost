# zb_api_server

|日期|操作人|模块|API名称|修订记录|
|:--|:--|:--|:--|:--|
|2017/11/11 |EASON|用户API |关注/取消关注|新增渠道字段，用于后台统计；API调整：/user/{userId}/**{channel}**/isAttention/{zbId}/{isAttention}|
|2017/11/11 |EASON|直播首页API|房间列表|新增分页返回总数**total**和总行数**rows**字段|
|2017/11/14 |EASON|三方平台API|获取列表IM/Media地址|新增主播id，用于auth认证；API调整：/api/platform/im/get/**{zbId}**；修改端口字段调整Integer类型|
|2017/11/15 |EASON|房间API|房间是否收费|新增返回用户试看信息，是否试看，试看时间等|
|2017/11/15 |EASON|直播首页API|房间列表|新增userId字段，用于获取当前用户收藏列表；API调整：/api/index/{category}/getIndexList/{position}/{pageSize}/**{userId}**|
|2017/11/16 |EASON|直播首页API|房间列表|删除userId字段，从token中获取；新增场次roomPlanId返回值，API调整：/api/index/{category}/getIndexList/{position}/{pageSize}|
|2017/11/16 |EASON|房间API|房间是否收费|删除userId字段，从token中获取；API调整：/room/{roomId}/isCharged|
|2017/11/17 |EASON|用户API|关注/取消关注|修改zbId字段，支持一键关注格式；API调整：/user/{channel}/isAttention/**{zbIds}**/{isAttention} |
|2017/11/17 |EASON|直播首页API|房间列表|新增返回值zbHeadImg、zbLevel字段，用户主播推荐|
|2017/11/17 |EASON|主播API|主播列表|用户主播推荐，删除userId字段，从token中获取；去掉不必要的字段|
|2017/11/17 |EASON|房间API|进入房间|修改用户等级字段类型String->Integer|
|2017/11/17 |EASON|房间API|进入房间|修改所有的场次planId字段类型String->Integer，用于与原点播系统统一|
|2017/11/18 |EASON|主播API|开始直播|删除userId字段，从token中获取；除去请求参数roomId，通过后台zdId获取|
|2017/11/18 |EASON|主播API|开始直播|修改startTime字段，所有的时间请传递Long类型的时间戳，修改持续时间设置String->Integer|
|2017/11/18 |EASON|主播API|获取开播信息 |重做此接口返回值|
|2017/11/18 |EASON|主播API|开始直播|重做此接口返回值|
|2017/11/20 |EASON|主播API|关于价格类型|所有的价格类型，全部修改未Double类型|
|2017/11/20 |EASON|房间API|获取房间属性设置|该接口暂时废弃，所有的房间属性初始化数据，从开播准备接口获取|
|2017/11/20 |EASON|房间API|设置房间直播封面|本测试平台不支持，测试文件上传接口，请使用Restclient等文件上传工具|
|2017/11/20 |EASON|用户API|关注/取消关注|修改zbId->userIds字段，支持一键关注格式(用户或者主播)；API调整：/user/{channel}/isAttention/**{userIds}**/{isAttention} |
|2017/11/20 |EASON|主播API|主播详情（迷你卡）|删除userId字段，从token中获取；API调整；用户等级String->Integer |
|2017/11/24 |EASON|三方平台API|获取列表IM/Media地址|新增token，用于auth认证； |
|2017/11/24|EASON|主播API|获取开播信息|返回值重做，请仔细看接口说明 |
|2017/11/24|EASON|房间API|房间是否收费|新增返回值timeInterval，用于收费间隔 |
|2017/11/27|EASON|房间API|退出房间 |新增统计相关的返回值，请仔细看接口说明 |
|2017/12/27|EASON|主播API|主播迷你卡 |新增zbUserLevel、zbUserVIP字段 |
|2017/12/27|EASON|用户API|用户迷你卡 |新增用户迷你卡API，请仔细看接口说明|