package com.eason.api.zb.model;

public interface ZbConstant  {
        interface response{
            interface code {
                int normal = 200;
                int error = 500;
            }
        }
        interface ZB{
            interface status {
                //1=正常，2=禁播
                int enable = 1;
                int disable = 2;
            }
        }

         interface Room{
              //0=创建，1=直播中，2=未开播，3=回放中;
             interface status{
                  int room_new=0;
                 int room_ing=1;
                 int room_closed=2;
                 int room_redio=3;
             }
             enum  Type {
                normal,ticket,time,personal,game
            }
            interface video{
                 //1=启用，0=不启用
                int enable=1;
                int disable=0;
            }
             interface close{
                 //1=正常关闭，2=异常关闭
                 int normal=1;
                 int error=2;
             }
        }
}
