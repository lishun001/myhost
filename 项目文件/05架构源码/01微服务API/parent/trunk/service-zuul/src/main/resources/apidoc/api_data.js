define({ "api": [
  {
    "version": "1.0.0",
    "group": "gift",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/gift/getList",
    "title": "礼物列表",
    "name": "getList",
    "description": "<blockquote> <p>点击送礼按钮，进入礼物列表</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "giftId",
            "description": "<p>礼物ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "giftName",
            "description": "<p>礼物名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "giftImg",
            "description": "<p>礼物图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "giftPrice",
            "description": "<p>礼物价格</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "specialStyle",
            "description": "<p>特效方式</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IGiftService.java",
    "groupTitle": "礼物API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//gift/getList"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "gift",
    "permission": [
      {
        "name": "IM"
      }
    ],
    "type": "GET",
    "url": "/gift/{userId}/sendBombScreen/{zbId}",
    "title": "发送飞屏",
    "name": "sendBombScreen",
    "description": "<blockquote> <p>在聊天窗口，选择飞屏，发送飞屏消息</br> 待定：IM实现？还是API实现？</br></p> </blockquote>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "msgText",
            "description": "<p>飞屏内容</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "diamondBalance",
            "description": "<p>用户钻石余额</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "cost",
            "description": "<p>消费金额</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IGiftService.java",
    "groupTitle": "礼物API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//gift/{userId}/sendBombScreen/{zbId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "gift",
    "permission": [
      {
        "name": "IM"
      }
    ],
    "type": "GET",
    "url": "/gift/{userId}/sendGift/{zbId}",
    "title": "发送礼物",
    "name": "sendGift",
    "description": "<blockquote> <p>在礼物列表，选好礼物跟价格，发送礼物</br> 待定：IM实现？还是API实现？</br></p> </blockquote>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "giftId",
            "description": "<p>礼物id</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "giftNum",
            "description": "<p>礼物数</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "diamondBalance",
            "description": "<p>用户钻石余额</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "cost",
            "description": "<p>消费金额</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IGiftService.java",
    "groupTitle": "礼物API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//gift/{userId}/sendGift/{zbId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "index",
    "type": "GET",
    "url": "/index/{category}/getBannerList",
    "title": "直播首页Banner列表",
    "name": "getBannerList",
    "description": "<blockquote> <p>需要显示Banner的模块：最新、最热</br> category 房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "id",
            "description": "<p>BannerID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>Banner标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "thumb_img_url",
            "description": "<p>Banner图片地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "eventUrl",
            "description": "<p>跳转地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>Banner类型（1=最新、3=最热）</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IIndexService.java",
    "groupTitle": "直播首页API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//index/{category}/getBannerList"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "index",
    "type": "GET",
    "url": "/index/{category}/getIndexList/{position}/{pageSize}",
    "title": "房间列表",
    "name": "getIndexList",
    "description": "<blockquote> <p>房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏 </br> 【最热=1】：砖石数排序（大-小）,主播昵称、直播标题、房间类型（若普通房间收费模式不现实）、房间人数（真实人数和机器人数）、网络状态（API不提供）</br> 【最新=3】：主播开播时间（近-远）排序，主播昵称、房间类型、房间人数（真实人数和机器人数）、网络状态（API不提供）</br> 【收藏=2】：显示关注后的主播房间,顺序直播类型-录播类型</br> (1)直播类型=砖石数排序（大-小）,直播状态、房间人数、主播昵称、开播信息、网络状态、收费模式（普通房间不显示）</br> (2)录播类型=发布日期（近-远），被观看次数、收费价格（普通房间不显示）、主播昵称、开播信息</br> 【付费=4】：砖石数排序（大-小）,开播标题、房间类型、房间人数（真实人数和机器人数）、网络状态（API不提供）</br> 【游戏=5】：房间游戏投注数排序（大-小）,主播昵称、开播标题、游戏类型、参与人数（如上第二条解释）、网络状态（API不提供）</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间ID</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbNickName",
            "description": "<p>主播昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomTitle",
            "description": "<p>房间标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','personal=私密房间','game=游戏房间'</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "onlineUser",
            "description": "<p>真实在线用户</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "machineUser",
            "description": "<p>机器用户</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomBackgroundImg",
            "description": "<p>房间背景图片</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbStatus",
            "description": "<p>直播状态： 1=直播中，2=未开播，3=回放中</p>"
          },
          {
            "group": "Success 200",
            "type": "Timestamp",
            "optional": false,
            "field": "startTime",
            "description": "<p>房间开播时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "gameIcon",
            "description": "<p>游戏图标</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IIndexService.java",
    "groupTitle": "直播首页API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//index/{category}/getIndexList/{position}/{pageSize}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "index",
    "type": "GET",
    "url": "/index/{category}/getMsgNotificationList",
    "title": "公告消息列表",
    "name": "getMsgNotificationList",
    "description": "<blockquote> <p>需要显示MsgNotification的模块：最新、最热</br> category 房间分类：1=最热（默认）、2=收藏、3=最新、4=付费、5=游戏</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "id",
            "description": "<p>公告消息ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>公告消息内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "url",
            "description": "<p>点击事件</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IIndexService.java",
    "groupTitle": "直播首页API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//index/{category}/getMsgNotificationList"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "platform",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/platform/im/get",
    "title": "获取im地址",
    "name": "getIM",
    "description": "<blockquote> <p>首次获取需要验证IM流权限，获取的key存入缓存，调用视频流的接口，获取推/拉流地址</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "type",
            "description": "<p>即时通讯类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "url",
            "description": "<p>即时通讯地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "port",
            "description": "<p>即时通讯端口</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "access_token",
            "description": "<p>访问token</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IPlatformService.java",
    "groupTitle": "三方平台API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//platform/im/get"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "platform",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/platform/media/get",
    "title": "获取media地址",
    "name": "getMedia",
    "description": "<blockquote> <p>首次获取需要验证media流权限，获取的key存入缓存，调用视频流的接口，获取推/拉流地址</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "type",
            "description": "<p>视频流类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "url",
            "description": "<p>视频流地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "access_token",
            "description": "<p>访问token</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IPlatformService.java",
    "groupTitle": "三方平台API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//platform/media/get"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "room",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/room/{roomId}/backRoom/{userId}",
    "title": "退出房间",
    "name": "backRoom",
    "description": "<blockquote> <p>主播结束直播，推送通知用户退出房间，当用户断线无法收到推送，如何判断？</br> （1）获取当前用户缓存: 开始时间，消费次数等</br> （2）记录观看时长，缓存数据统计到数据库。做账，消费统计</br> （3）清除当前用户缓存，退出成功</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "result",
            "description": "<p>退房成功或者失败</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IRoomService.java",
    "groupTitle": "房间API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//room/{roomId}/backRoom/{userId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "room",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/room/{roomId}/enterRoom/{userId}",
    "title": "进入房间",
    "name": "enterRoom",
    "description": "<blockquote> <p>用户与主播，进入房间，获取房间详情明细，包含如下几个动作：</br> （1）获取房间详情</br> （2）获取主播详情</br> （3）获取用户详情</br> （4）获取粉丝用户列表</br> （5）获取IM/Video服务器地址</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomTitle",
            "description": "<p>房间标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型：'normal=普通房间','ticket=门票房间','time=时常房间','personal=私密房间','game=游戏房间'</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "onlineUser",
            "description": "<p>房间当前在线用户</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "machineUser",
            "description": "<p>房间用户</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondGiftNum",
            "description": "<p>房间钻石礼物总数</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomNo1",
            "description": "<p>房间排名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomBackgroundImg",
            "description": "<p>房间背景图片</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbNickname",
            "description": "<p>主播昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbLevel",
            "description": "<p>主播等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbHeadImg",
            "description": "<p>主播头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbSignature",
            "description": "<p>主播个性签名</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "isAttention",
            "description": "<p>用户是否关注</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevel",
            "description": "<p>用户等级息</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "diamondBalance",
            "description": "<p>用户钻石余额</p>"
          },
          {
            "group": "Success 200",
            "type": "Object[]",
            "optional": false,
            "field": "diamondRankList",
            "description": "<p>diamondRankList-&gt;user（送礼钻石排行）</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondRankList.user.userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "diamondRankList.user.nickName",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "diamondRankList.user.sex",
            "description": "<p>用户性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "diamondRankList.user.userHeadImg",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "diamondRankList.user.userLevel",
            "description": "<p>用户等级</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondRankList.user.giftRankNo1",
            "description": "<p>当前送礼排行</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondRankList.user.diamondGiftUserTotal",
            "description": "<p>当前用户在当前房间累计送礼总数</p>"
          },
          {
            "group": "Success 200",
            "type": "Object[]",
            "optional": false,
            "field": "userLevelRankList",
            "description": "<p>userLevelRankList-&gt;user（用户等级排行）</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userLevelRankList.user.userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevelRankList.user.nickName",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevelRankList.user.sex",
            "description": "<p>用户性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevelRankList.user.userHeadImg",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevelRankList.user.userLevel",
            "description": "<p>用户等级</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "media",
            "description": ""
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "media.type",
            "description": "<p>视频流类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "media.url",
            "description": "<p>视频流地址</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "im",
            "description": ""
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "im.type",
            "description": "<p>即时通讯类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "im.url",
            "description": "<p>即时通讯地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "im.port",
            "description": "<p>即时通讯端口</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IRoomService.java",
    "groupTitle": "房间API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//room/{roomId}/enterRoom/{userId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "room",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/room/{roomType}/getRoomSet",
    "title": "获取房间属性设置",
    "name": "getRoomSet",
    "description": "<blockquote> <p>进入主播开播界面，动态展示开播前的房间设置参数</br> （1）房间有参数的类型roomType=ticket，time，personal</br></p> </blockquote>",
    "success": {
      "fields": {
        "ticket Success 200": [
          {
            "group": "ticket Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "Timestamp",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "String",
            "optional": false,
            "field": "price",
            "description": "<p>每分钟单价=[1,2,5,10]</p>"
          }
        ],
        "time Success 200": [
          {
            "group": "time Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "time Success 200",
            "type": "Timestamp",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "time Success 200",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "time Success 200",
            "type": "String",
            "optional": false,
            "field": "price",
            "description": "<p>门票单价=[20,50,100,120]</p>"
          }
        ],
        "personal Success 200": [
          {
            "group": "personal Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "personal Success 200",
            "type": "Timestamp",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间</p>"
          },
          {
            "group": "personal Success 200",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "personal Success 200",
            "type": "String",
            "optional": false,
            "field": "userIds",
            "description": "<p>贵宾的用户id=[user001,user002,user003]</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IRoomService.java",
    "groupTitle": "房间API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//room/{roomType}/getRoomSet"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "room",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/room/{roomId}/isCharged/{userId}",
    "title": "房间是否收费",
    "name": "isCharged",
    "description": "<blockquote> <p>判断房间是否收费，获取收费条件等信息</br> （1）房间收费类型roomType=ticket，time，personal</br></p> </blockquote>",
    "success": {
      "fields": {
        "ticket Success 200": [
          {
            "group": "ticket Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间ID</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "Integer",
            "optional": false,
            "field": "ticketStatus",
            "description": "<p>0=未购买，1=购买，2=使用中，3=已使用，4=已作废</p>"
          },
          {
            "group": "ticket Success 200",
            "type": "Double",
            "optional": false,
            "field": "price",
            "description": "<p>门票单价</p>"
          }
        ],
        "time Success 200": [
          {
            "group": "time Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间ID</p>"
          },
          {
            "group": "time Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "time Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "time Success 200",
            "type": "Integer",
            "optional": false,
            "field": "price",
            "description": "<p>时长单价</p>"
          },
          {
            "group": "time Success 200",
            "type": "String",
            "optional": false,
            "field": "unit",
            "description": "<p>时长单位</p>"
          }
        ],
        "personal Success 200": [
          {
            "group": "personal Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间ID</p>"
          },
          {
            "group": "personal Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "personal Success 200",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "personal Success 200",
            "type": "Integer",
            "optional": false,
            "field": "personalStatus",
            "description": "<p>0=未预约，1=已预约</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IRoomService.java",
    "groupTitle": "房间API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//room/{roomId}/isCharged/{userId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "room",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "POST",
    "url": "/room/{roomId}/setRoomBackgroundImg",
    "title": "设置房间直播封面",
    "name": "setRoomBackgroundImg",
    "description": "<blockquote> <p>进入主播开播界面，设置直播房间封面</br></p> </blockquote>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "byte[]",
            "optional": false,
            "field": "roomBackgroundImg",
            "description": "<p>房间背景图</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "imgUrl",
            "description": "<p>上传地址</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IRoomService.java",
    "groupTitle": "房间API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//room/{roomId}/setRoomBackgroundImg"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "user",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/user/{userId}/getDetail",
    "title": "用户详情",
    "name": "getDetail",
    "description": "<blockquote> <p>用户关注主播，关注与未关注来回切换</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "nickName",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>用户性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userHeadImg",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevel",
            "description": "<p>用户等级</p>"
          },
          {
            "group": "Success 200",
            "type": "Double",
            "optional": false,
            "field": "diamondBalance",
            "description": "<p>用户钻石余额</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "diamondGiftUserTotal",
            "description": "<p>当前用户在当前房间累计送礼总数</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "giftRankNo1",
            "description": "<p>当前送礼排行</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IUserService.java",
    "groupTitle": "用户API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//user/{userId}/getDetail"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "user",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/user/{userId}/isAttention/{zbId}/{isAttention}",
    "title": "关注/取消关注",
    "name": "isAttention",
    "description": "<blockquote> <p>用户关注主播，关注与未关注来回切换</br> isAttention=true,false </br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "result",
            "description": "<p>关注成功或者失败消息</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IUserService.java",
    "groupTitle": "用户API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//user/{userId}/isAttention/{zbId}/{isAttention}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "user",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/user/{userId}/isBook/{zbId}/{isBook}",
    "title": "预约/取消预约",
    "name": "isBook",
    "description": "<blockquote> <p>用户关注主播，关注与未关注来回切换</br> isBook=true,false </br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "result",
            "description": "<p>关注成功或者失败消息</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IUserService.java",
    "groupTitle": "用户API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//user/{userId}/isBook/{zbId}/{isBook}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "user",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/user/{userId}/isTrySee/{roomId}/{isTrySee}",
    "title": "开始/结束试看",
    "name": "isTrySee",
    "description": "<blockquote> <p>判断当前VIP用户是否能试看，如果可以开始试看</br> isTrySee=true,false</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isTrySee",
            "description": "<p>false=未试看，true=已试看</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userLevel",
            "description": "<p>用户等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "allowTime",
            "description": "<p>允许试看时间</p>"
          },
          {
            "group": "Success 200",
            "type": "Timestamp",
            "optional": false,
            "field": "overTime",
            "description": "<p>试看结束时间</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IUserService.java",
    "groupTitle": "用户API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//user/{userId}/isTrySee/{roomId}/{isTrySee}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/{zbId}/getAttentionUserList",
    "title": "主播获取关注用户列表",
    "name": "getAttentionUserList",
    "description": "<blockquote> <p>点击主播粉丝用户列表，获取用户列表</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object[]",
            "optional": false,
            "field": "userList",
            "description": "<p>userList-&gt;user</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userList.user.userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.nickName",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.sex",
            "description": "<p>用户性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.userHeadImg",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.userLevel",
            "description": "<p>用户等级</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{zbId}/getAttentionUserList"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/{zbId}/getGiftUserList/{category}",
    "title": "主播收礼排行用户列表",
    "name": "getGiftUserList",
    "description": "<blockquote> <p>点击钻石礼物，弹出礼物排行对话框</br> category =today，history （1）点击当日，获取当日送礼排行</br> （2）点击全部，获取历史送礼排行</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object[]",
            "optional": false,
            "field": "userList",
            "description": "<p>userList-&gt;user</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "userList.user.userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.nickName",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.sex",
            "description": "<p>用户性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.userHeadImg",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.userLevel",
            "description": "<p>用户等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.giftRankNo1",
            "description": "<p>当前送礼排行</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "userList.user.diamondGiftUserTotal",
            "description": "<p>当前用户在当前房间累计送礼总数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{zbId}/getGiftUserList/{category}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/{zbId}/getReadyPlayInfo",
    "title": "获取开播信息",
    "name": "getReadyPlayInfo",
    "description": "<blockquote> <p>进入主播开播界面</br> （1）获取IM地址</br> （2）获取Madia地址</br> （3）获取房间信息</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "roomBackgroundImg",
            "description": "<p>房间背景图</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "media",
            "description": ""
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "media.type",
            "description": "<p>视频流类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "media.url",
            "description": "<p>视频流地址</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "im",
            "description": ""
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "im.type",
            "description": "<p>即时通讯类型</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "im.url",
            "description": "<p>即时通讯地址</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "im.port",
            "description": "<p>即时通讯端口</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{zbId}/getReadyPlayInfo"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/{userId}/getZbDetail/{zbId}",
    "title": "主播详情",
    "name": "getZbDetail",
    "description": "<blockquote> <p>点击主播头像，进入主播迷你卡，获取主播详情</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbNickname",
            "description": "<p>主播昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbLevel",
            "description": "<p>主播等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbHeadImg",
            "description": "<p>主播头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbSignature",
            "description": "<p>主播个性签名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbBackgroundImg",
            "description": "<p>直播背景图片</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "isAttention",
            "description": "<p>用户是否关注</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "attentionUserTotal",
            "description": "<p>粉丝：已关注主播的人数</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondGiftZBTotal",
            "description": "<p>收礼：主播累计收礼统计</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "costTotal",
            "description": "<p>消费</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{userId}/getZbDetail/{zbId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/getZhuboList/{userId}",
    "title": "主播列表",
    "name": "overPlay",
    "description": "<blockquote> <p>点击收藏，没有关注列表，显示热门推荐主播</br> 如果没有登陆，只需要传递0即可：/zhubo/getZhuboList/0</br> 如果有登陆，只需要传递userId即可：/zhubo/getZhuboList/2</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "zbId",
            "description": "<p>主播ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbNickname",
            "description": "<p>主播昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbLevel",
            "description": "<p>主播等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbHeadImg",
            "description": "<p>主播头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbSignature",
            "description": "<p>主播个性签名</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "zbBackgroundImg",
            "description": "<p>直播背景图片</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "isAttention",
            "description": "<p>用户是否关注</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "attentionUserTotal",
            "description": "<p>粉丝：已关注主播的人数</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "diamondGiftZBTotal",
            "description": "<p>收礼：主播累计收礼统计</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "costTotal",
            "description": "<p>当前用户消费。如果没有用户，忽略此字段</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/getZhuboList/{userId}"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "GET",
    "url": "/zhubo/{zbId}/overPlay",
    "title": "结束直播",
    "name": "overPlay",
    "description": "<blockquote> <p>点击是否结束直播，结束直播</br> （1）关闭房间</br> （2）获取缓存: 砖石数，礼物数等</br> （3）做账，收益统计</br> （4）清除当前房间缓存</br> （5）房间清算完成</br></p> </blockquote>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "result",
            "description": "<p>关播成功或失败</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{zbId}/overPlay"
      }
    ]
  },
  {
    "version": "1.0.0",
    "group": "zhubo",
    "permission": [
      {
        "name": "Android/IOS"
      }
    ],
    "type": "POST",
    "url": "/zhubo/{zbId}/startPlay",
    "title": "开始直播",
    "name": "startPlay",
    "description": "<blockquote> <p>点击开始直播，进入直播界面</br> （1）直播房间状态更新</br> （2）发送开播推送</br></p> </blockquote>",
    "parameter": {
      "fields": {
        "ticket": [
          {
            "group": "ticket",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间id</p>"
          },
          {
            "group": "ticket",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "ticket",
            "type": "String",
            "size": "0..10",
            "optional": false,
            "field": "roomTitle",
            "description": "<p>房间标题</p>"
          },
          {
            "group": "ticket",
            "type": "String",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间（yyyy-MM-dd HH:mm:ss）</p>"
          },
          {
            "group": "ticket",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "ticket",
            "type": "String",
            "optional": false,
            "field": "price",
            "description": "<p>每分钟单价=[1,2,5,10]</p>"
          }
        ],
        "time": [
          {
            "group": "time",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间id</p>"
          },
          {
            "group": "time",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "time",
            "type": "String",
            "size": "0..10",
            "optional": false,
            "field": "roomTitle",
            "description": "<p>房间标题</p>"
          },
          {
            "group": "time",
            "type": "String",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间（yyyy-MM-dd HH:mm:ss）</p>"
          },
          {
            "group": "time",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "time",
            "type": "String",
            "optional": false,
            "field": "price",
            "description": "<p>门票单价=[20,50,100,120]</p>"
          }
        ],
        "personal": [
          {
            "group": "personal",
            "type": "Integer",
            "optional": false,
            "field": "roomId",
            "description": "<p>房间id</p>"
          },
          {
            "group": "personal",
            "type": "String",
            "allowedValues": [
              "\"normal\"",
              "\"ticket\"",
              "\"time\"",
              "\"personal\"",
              "\"game\""
            ],
            "optional": false,
            "field": "roomType",
            "description": "<p>房间类型</p>"
          },
          {
            "group": "personal",
            "type": "String",
            "size": "0..10",
            "optional": false,
            "field": "roomTitle",
            "description": "<p>房间标题</p>"
          },
          {
            "group": "personal",
            "type": "String",
            "optional": false,
            "field": "startTime",
            "description": "<p>开始时间（yyyy-MM-dd HH:mm:ss）</p>"
          },
          {
            "group": "personal",
            "type": "String",
            "optional": false,
            "field": "activityTime",
            "description": "<p>继续时间=[30,60,90,120]</p>"
          },
          {
            "group": "personal",
            "type": "String",
            "optional": false,
            "field": "userIds",
            "description": "<p>贵宾的用户id=[user001,user002,user003]</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "result",
            "description": "<p>开播成功或失败</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/eason/api/zb/service/IZhuboService.java",
    "groupTitle": "主播API",
    "sampleRequest": [
      {
        "url": "http://192.168.0.109:8769/api//zhubo/{zbId}/startPlay"
      }
    ]
  }
] });
