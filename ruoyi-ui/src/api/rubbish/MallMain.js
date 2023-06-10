import request from '@/utils/request'

// 查询积分商城管理列表
export function listMallMain(query) {
  return request({
    url: '/rubbish/MallMain/list',
    method: 'get',
    params: query
  })
}

// 查询积分商城管理详细
export function getMallMain(id) {
  return request({
    url: '/rubbish/MallMain/' + id,
    method: 'get'
  })
}

// 新增积分商城管理
export function addMallMain(data) {
  return request({
    url: '/rubbish/MallMain',
    method: 'post',
    data: data
  })
}

// 修改积分商城管理
export function updateMallMain(data) {
  return request({
    url: '/rubbish/MallMain',
    method: 'put',
    data: data
  })
}

// 删除积分商城管理
export function delMallMain(id) {
  return request({
    url: '/rubbish/MallMain/' + id,
    method: 'delete'
  })
}
